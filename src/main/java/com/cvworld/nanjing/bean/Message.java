package com.cvworld.nanjing.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
  * @description 消息通知
  * @author majinming@xiaomi.com
  * @date 2021年 03月15日 09:41
  *@param 
  *@retgurn 
  */
@Data
 @Entity
 @Table(name = "t_messages")
public class Message {
 @Id //主键标识
 @GeneratedValue(strategy =  GenerationType.IDENTITY)
 private Long id;
 private Long toUserId;
 private String description;
 private boolean isRead;
 private boolean isDelete;

 @Temporal(TemporalType.TIMESTAMP)
 private Date creatTime;

 private int type ;// 0:点赞　１：评论　２：通知
 private String creatUserName;


}
