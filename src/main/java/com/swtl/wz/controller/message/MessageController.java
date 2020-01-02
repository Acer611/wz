package com.swtl.wz.controller.message;

import com.swtl.wz.entity.vo.response.message.MessageResponse;
import com.swtl.wz.service.message.IMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 消息信息的控制层代码
 */
@Api(tags = "消息信息的接口" ,value = "获取消息信息的接口",description = "获取系统内消息 和其他消息的接口")
@RestController
@RequestMapping("/api/message")
public class MessageController  {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private IMessageService messageService;

    /**
     * 获取所有消息
     * @return
     */
    @ApiOperation(value = "获取所有消息")
    @ResponseBody
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    public MessageResponse listAll(@RequestHeader(required = false, value = "token") String token,
                                   @ApiParam(value = "用户的ID  没有传-1") @RequestParam(required = false,defaultValue = "-1") Long userId,
                                   @ApiParam(value = "状态 -1 所有  0 未读  1 已读")@RequestParam(name = "status",defaultValue = "-1") int status,
                                   @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10")int pageSize){
        MessageResponse messageResponse = new MessageResponse();
        String user = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (user!=null){
            userId = Long.parseLong(user);
        }else{
            userId =-1L;
        }

        messageResponse = messageService.listAll(userId,status,pageNum,pageSize);
        return messageResponse;
    }



    /**
     * 阅读消息
     * @param token
     * @param messageID
     * @return
     */
    @ApiOperation(value = "用户阅读某一条消息")
    @ResponseBody
    @RequestMapping(value = "/readMessage",method = RequestMethod.GET)
    public MessageResponse readMessage(@RequestHeader(required = false, value = "token") String token,
                                       @ApiParam(value = "用户的ID  没有传-1") @RequestParam(required = false) Long userId,
                                       @ApiParam(value = "消息的ID") @RequestParam(name = "messageID") Long messageID){
        MessageResponse messageResponse = new MessageResponse();
       /* String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId==null){
            messageResponse.setRetCode(5002);
            messageResponse.setRetMsg("用户不存在！");
            return  messageResponse;
        }*/

        messageResponse = messageService.readMessage(userId,messageID);
        return  messageResponse;

    }

}
