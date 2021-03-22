package com.laoma.admin.controller.AdminController;

import com.laoma.admin.MD5uitk.MD5Uitl;
import com.laoma.admin.bean.Message;
import com.laoma.admin.bean.Role;
import com.laoma.admin.bean.User;
import com.laoma.admin.service.MessageService;
import com.laoma.admin.service.RoleService;
import com.laoma.admin.service.UserService;
import com.laoma.admin.utils.MessageUtil;
import com.laoma.admin.utils.SuperAdminMseeageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MessageService messageService;


    @RequestMapping("toAddUser")
    public  String toAdd(Model model){

        List<Role> roleList=roleService.findAll();
        model.addAttribute("roles",roleList);
        return "User/add";
    }

    @RequestMapping("/userAdd")
    public String add(@Valid User user, HttpSession session){

        String passeords=user.getPassword();
        System.out.println(passeords);
        user.setPassword(MD5Uitl.stringMD5(passeords));

        if (user.getId()== null){
            Date nowTime = new Date();
            String nowsolftId = "622202" +nowTime.getSeconds() + "320" + nowTime.getDay() + nowTime.getHours ()+nowTime.getMinutes()+ nowTime.getHours ()+nowTime.getSeconds();
            System.out.println(nowsolftId);
            user.setUsernum(nowsolftId);
        }

        //判断是否进行了更改
        User oldUser =  userService.findUser(user.getId());
        if (! oldUser.equales(user)){
            try{
                User newOldUser = new User();
                newOldUser.setStatus(oldUser.isStatus());
                newOldUser.setRole(oldUser.getRole());
                user.setTime(new Date());
                userService.saveuser(user);
                user.setRole(roleService.findRole(user.getRole().getId()));
                //消息描述
                String des = SuperAdminMseeageUtil.messageSuperAdmin(newOldUser,oldUser);
                if (!"".equals(des)){
                    StringBuilder sqlDescri = new StringBuilder("系统通知： ");
                    sqlDescri.append(des);
                    sqlDescri.append("详情请咨询教务处(电话)：4630445");
                    String description = new String(sqlDescri);
                    //创建消息通知
                    Message message = new Message();
                    MessageUtil.creatMessage(message,"系统管理员",user.getId(),2,description);
                    messageService.creatMessage(message);
                }
            }catch (Exception e){
                throw new RuntimeException("用户修改失败",e);
            }
        }
        return "redirect:/userMange";
    }

    //模糊查询
    @GetMapping("/searchUser")
    public String search(Model model,@RequestParam("username") String username){

        model.addAttribute("user",userService.listUser("%"+username+"%"));
        model.addAttribute("query",username);
        System.out.println(username);
        return "User/index";
    }

    @RequestMapping("/user/{id}/toUpdate")
    public String updateUser(@PathVariable Long id, Model model,HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        User user=userService.findUser(id);
        System.out.println(user.toString());
        model.addAttribute("users",user);
        List<Role> roleList= roleService.findAll();
        model.addAttribute("roles",roleList);
//        response.getWriter().write("<script>alert('修改成功！');</script>");
        response.getWriter().flush();
        return "User/edit";
    }

    //删除操作
    @RequestMapping("/user/{id}/delete")
    public String delete(@PathVariable Long id,Model model,HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        userService.deleteById(id);
        response.getWriter().write("<script>alert('删除成功！');</script>");
        response.getWriter().flush();
        model.addAttribute("user",userService.findall());
        return "User/index";
    }
}
