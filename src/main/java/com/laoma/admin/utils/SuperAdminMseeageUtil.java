package com.laoma.admin.utils;

import com.laoma.admin.bean.User;

/**
  * @description 
  * @author majinming@xiaomi.com
  * @date 2021年 03月15日 11:45
  *@param 
  *@retgurn 
  */
public class SuperAdminMseeageUtil {

 public static String messageSuperAdmin(User oldUser, User newUser){
  StringBuilder stringBuilder = new StringBuilder("");
  //状态变更
  if (newUser.isStatus()!= oldUser.isStatus()){
   if (!newUser.isStatus()){
    stringBuilder.append("您的系统账号因违规被封停;");
   }else {
    stringBuilder.append("您的系统账号已被解封;");
   }
  }
  //权限变化
//  if (!oldUser.getRole().equales(newUser.getRole())){
//   stringBuilder.append("您的系统权限已经变更为：＂"+newUser.getRole().getRolename()+" ＂。");
//  }
  return stringBuilder.toString();
 }
}
