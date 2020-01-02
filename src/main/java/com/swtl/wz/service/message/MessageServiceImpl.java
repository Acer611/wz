package com.swtl.wz.service.message;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swtl.wz.dao.message.MessageMapper;
import com.swtl.wz.entity.po.message.MessageEntity;
import com.swtl.wz.entity.vo.response.message.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 消息的业务处理层
 */
@Service(value = "messageService")
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;
    /**
     * 获取所有消息信息
     *
     * @param userId
     * @param pageNum
     * @param userId
     * @return
     */
    @Override
    public MessageResponse listAll(Long userId, int status ,int pageNum, int pageSize) {
        MessageResponse messageResponse = new MessageResponse();
        PageHelper.startPage(pageNum, pageSize);
        List<MessageEntity> messageEntityList = messageMapper.listAll(userId,status);

        PageInfo result = new PageInfo(messageEntityList);

        messageResponse.setPageInfo(result);
        return messageResponse;
    }

    /**
     * 用户阅读一条消息
     * @param userId
     * @param messageID
     * @return
     */
    @Override
    public MessageResponse readMessage(Long userId, Long messageID) {
        MessageResponse messageResponse = new MessageResponse();


        MessageEntity messageEntity = messageMapper.findMessageByUserIdMessageId(messageID);
        if(messageEntity==null){
            messageResponse.setRetCode(6001);
            messageResponse.setRetMsg("当前消息不存在，请检查入参！！");
        }

        if(messageEntity.getType()==1){
            messageMapper.updateStatus(userId,messageID);
        }


        return messageResponse;
    }
}
