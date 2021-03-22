package com.laoma.admin.utils;

import com.laoma.admin.bean.Message;

import java.util.Date;

/**
  * @description 
  * @author majinming@xiaomi.com
  * @date 2021年 03月15日 12:17
  *@param 
  *@retgurn 
  */
public class MessageUtil {

 /**
  *
  * @param creatName
  * @param toUserId
  * @param type
  * @param des　消息内容
  * @return 一个创建好的新消息
  */
 public static Message creatMessage(Message message,String creatName,Long toUserId,int type,String des){

/*  //点赞
  if (type == 0){

  }else if (type == 1){
   //评论

  }else if (type ==2){
   //通知

  }*/
  message.setToUserId(toUserId);
  message.setDescription(des);
  message.setType(type);
  message.setCreatUserName(creatName);
  message.setCreatTime(new Date());
  message.setDelete(false);
  message.setRead(false);
  return message;
 }
}
