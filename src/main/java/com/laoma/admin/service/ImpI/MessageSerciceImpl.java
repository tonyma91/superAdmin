package com.laoma.admin.service.ImpI;

import com.laoma.admin.bean.Message;
import com.laoma.admin.dao.MessageDao;
import com.laoma.admin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * @description 
  * @author majinming@xiaomi.com
  * @date 2021年 03月15日 14:55
  *@param 
  *@retgurn 
  */
@Service
public class MessageSerciceImpl implements MessageService {
 @Autowired
 private MessageDao messageDao;
 /**
  * 查询用户未读消息
  *
  * @param toUserId
  * @return
  */
 @Override
 public Map<Integer,List<Message>> findByUserId(Long toUserId) {
  Map<Integer,List<Message>> map = new HashMap<>(16);
  //插叙用户韦德的三种类型的消息
  map.put(0,messageDao.findByToUserIdAndIsReadAndType(toUserId,false,0));
  map.put(1,messageDao.findByToUserIdAndIsReadAndType(toUserId,false,1));
  map.put(2,messageDao.findByToUserIdAndIsReadAndType(toUserId,false,2));

  //查询后讲这些消息设置为已读
  List<Message> messageList = messageDao.findByToUserId(toUserId);
  if (messageList.size() != 0){
   try {
    for (Message message:messageList){
     message.setRead(true);
    }
    messageDao.saveAll(messageList);
   }catch (Exception e){
    throw new RuntimeException("查询用户未读消息时出错",e);
   }

  }
  return map;
 }

 /**
  * 批量修改消息
  * 如　设置已读
  * //TODO 此方法已经废弃，改为在查询后就直接设置为已读状态
  * @param messageList
  * @return
  */
 @Override
 public boolean saveMessage(List<Message> messageList) {
  messageDao.saveAll(messageList);
  return false;
 }

 /**
  * 创建消息
  *
  * @param message
  * @return
  */
 @Override
 public boolean creatMessage(Message message) {
  messageDao.save(message);
 /* if (null ==messageDao.save(message)){
   return false ;
  }*/
  return true;
 }
}
