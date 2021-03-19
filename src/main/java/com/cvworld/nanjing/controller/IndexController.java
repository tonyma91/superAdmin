package com.cvworld.nanjing.controller;

import com.cvworld.nanjing.MD5uitk.MD5Uitl;
import com.cvworld.nanjing.bean.Role;
import com.cvworld.nanjing.bean.User;
import com.cvworld.nanjing.service.MenuService;
import com.cvworld.nanjing.service.OrganService;
import com.cvworld.nanjing.service.RoleService;
import com.cvworld.nanjing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cvworld.nanjing.bean.Organ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
    public class IndexController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrganService organService;

       @RequestMapping("/")
        public  String welcomToblue(){ return "welcom"; }

    @RequestMapping("/toLogin")
    public  String toLogin(){
           return "Public/login"; }





    @RequestMapping("/exict")
    public  String exict(HttpSession session){
           session.removeAttribute("user");
           return "redirect:/"; }


@RequestMapping("/tologin")
public  String exict(@RequestParam("username") String username,
                     @RequestParam("password") String password,
                     @RequestParam("verify") String verify,
                     Model model, HttpServletResponse response ,
                     HttpSession session,  HttpServletRequest request) throws IOException {

    response.setContentType("text/html;charset=utf-8");
    //创建session域的对象，获取域中的数据
    //TODO 测试阶段暂时不使用验证码

    /*if (!session.getAttribute("randCheckCode").toString().equalsIgnoreCase(verify)) {
        response.getWriter().write("<script>alert('验证码错误！！');</script>");
        response.getWriter().flush();
        return "Public/login";
    }*/
    //TODO 测试阶段　暂时不使用ＭＤ５
    /*String passeords=new String(MD5Uitl.stringMD5(password));
    User user = userService.findUser(username,passeords);
    */
    //TODO 测试阶段用户查询，发布时需要去除
    User user = userService.findUser(username,password);
    // 用户校验
    if(user == null) {
        response.getWriter().write("<script>alert('请检查登录名及密码是否正确！');</script>");
        response.getWriter().flush();
        return "Public/login";
    }
    if (!user.isStatus()){
        response.getWriter().write("<script>alert('当前账号已禁用！');</script>");
        response.getWriter().flush();
        return "Public/login";
    }
    user.setTime(new Date());
    userService.saveuser(user);
    model.addAttribute("user",user);
    return "index";
}


//进入主页
    @RequestMapping("/index")
    public  String index(Model model){

    User user = (User) model.getAttribute("user");
    if(user == null)
        return "Public/login";
    return "index";
}

//跳转到机构展示页面
@RequestMapping("nodeMange")
public  String nodeManage(@PageableDefault(size = 4,sort = {"id"},direction = Sort.Direction.ASC)
                                  Pageable pageable,Model model){
    Page<Organ> organList = organService.findAll(pageable);
    model.addAttribute("page",organList);
    return "Node/index";
}

    @RequestMapping("roleManage")
   public  String roleManage(Model model){
    List<Role> roleList= roleService.findAll();
    model.addAttribute("role",roleList);
    return "Role/index";
}


       @RequestMapping("userMange")
       public  String userMange(Model model){
           List<User> userList=userService.findall();
           model.addAttribute("user",userList);
           return "User/index";
       }

    @RequestMapping("menuMange")
    public  String menuManage(Model model){
        model.addAttribute("menu", menuService.listMenu());
        return "Menu/index";
    }
}
