package com.swtl.wz.dao.message;

import com.swtl.wz.dao.sqlprovider.JobPositionProvider;
import com.swtl.wz.dao.sqlprovider.MessageSQLProvider;
import com.swtl.wz.entity.po.message.MessageEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 消息的数据处理层接口
 */
@Mapper
public interface MessageMapper {

    /**
     * 查询所有消息信息
     * @param userId
     * @return
     */

    @SelectProvider(type = MessageSQLProvider.class, method = "listAll")
    List<MessageEntity> listAll(@Param("userId") Long userId, @Param("status")Integer status);

    /**
     *阅读一条消息
     * @param messageID
     * @return
     */
    @Select(" SELECT id,type,ifnull(title,'')AS title,IFNULL(content,'')AS content,IFNULL(`status`, 0) AS `status`, IFNULL(`createTime`, NOW()) AS `createTime`," +
            "  IFNULL(userId,0) AS userId  FROM t_message WHERE id=#{messageID}")
    MessageEntity findMessageByUserIdMessageId( @Param("messageID")Long messageID);

    /**
     * 用户阅读一条消息
     * @param userId
     * @param messageID
     */
    @Select(" update t_message set status=1 WHERE userId = #{userId} and id = #{messageID}")
    void updateStatus(@Param("userId")Long userId, @Param("messageID")Long messageID);
}
