package com.cvworld.nanjing.dao;

import com.cvworld.nanjing.bean.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageDao extends JpaRepository<Message,Long> {
    /**
     * 查询用户未读消息
     * @param toUserId
     * @param type
     * @param isRead
     * @return
     */
    List<Message> findByToUserIdAndIsReadAndType(Long toUserId,boolean isRead,int type);

    /**
     * 查询该用户的所有消息
     * @param toUserId
     * @return
     */
    List<Message> findByToUserId(Long toUserId);
}
