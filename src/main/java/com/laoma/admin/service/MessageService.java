package com.laoma.admin.service;

import com.laoma.admin.bean.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {
    /**
     *  查询用户未读消息
     * @param toUserId
     * type 不同的额类型返回不同的结果
     * @return
     */
    Map<Integer,List<Message>> findByUserId(Long toUserId);


    /**
     * 批量修改消息
     * 如　设置已读
     * @param messageList
     * @return
     */
    boolean saveMessage(List<Message> messageList);

    /**
     * 创建消息
     * @param message
     * @return
     */
    boolean creatMessage(Message message);
}
