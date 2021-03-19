package com.cvworld.nanjing.controller.AdminController;

import com.cvworld.nanjing.bean.Role;
import com.cvworld.nanjing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import com.sd365.common.core.annotation.stuffer.IdGenerator;
import java.io.IOException;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
//    private IdGenerator idGenerator;

    @RequestMapping("toAddRole")
    public String toRoleAdd(){
        return "Role/add";
    }
    @RequestMapping("/roleAdd")
    public String roleAdd(Role role, RedirectAttributes attributes, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        Role role1 = roleService.getRoleByName(role.getRolename());
        if(role1==null) {
            roleService.saveRole(role);
            System.out.println("新增角色"+role.toString());
            return "redirect:/roleManage";
        }else{
            response.getWriter().write("<script>alert('请输入正确的角色名称（不可与已知角色重复）！');</script>");
            response.getWriter().flush();
            return "redirect:/roleManage";
        }
    }

    //这里只是将编辑的角色内容显示出来，Role/edit的实现函数->roleAdd
    @RequestMapping("/role/{id}/toUpdate")
    public String updateRole(@PathVariable Long id, Model model){
        Role role=roleService.findRole(id);
        System.out.println(role.toString());
        model.addAttribute("role",role);
        return "Role/edit";
    }


    @RequestMapping("/roleUpdate")
    public String roleUpdate(Role role ,HttpServletResponse response) throws IOException {

        roleService.saveRole(role);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script>alert('修改成功！');</script>");
        response.getWriter().flush();
        return "redirect:/roleManage";
        }


        @RequestMapping("/role/{id}/delete")
    public String deleteRole(@PathVariable Long id,Model model,HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        Role role=roleService.findRole(id);
        roleService.deleteRole(role);
        response.getWriter().write("<script>alert('删除成功！');</script>");
        response.getWriter().flush();
        model.addAttribute("role",role);
        return"redirect:/roleManage";
    }

    @RequestMapping("/searchRole")
    public String searchRole(@RequestParam("rolename") String rolename, Model model,HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Role role=roleService.getRoleByName(rolename);
        if(role!=null){
            System.out.println("查找角色"+role.toString());
            model.addAttribute("role",role);
            return"Role/index";
        }else{
            response.getWriter().write("<script>alert('查询不到该管理员！');</script>");
            response.getWriter().flush();
            return"Role/index";
        }
    }
}
