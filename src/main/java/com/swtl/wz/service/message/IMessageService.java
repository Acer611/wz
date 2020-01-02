package com.swtl.wz.service.message;

import com.swtl.wz.entity.vo.response.message.MessageResponse;

/**
 * 消息的业务处理层
 */
public interface IMessageService {
    /**
     * 获取所有消息
     * @return
     * @param userId
     * @param pageNum
     * @param pageSize
     */
    MessageResponse listAll(Long userId,int status, int pageNum, int pageSize);

    /**
     *
     * @param userId
     * @param messageID
     * @return
     */
    MessageResponse readMessage(Long userId, Long messageID);
}
