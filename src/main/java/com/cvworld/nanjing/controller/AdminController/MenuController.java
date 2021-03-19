package com.cvworld.nanjing.controller.AdminController;

import com.cvworld.nanjing.bean.Menu;
import com.cvworld.nanjing.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("toMenuAdd")
    public String toMenuAdd() {
        return "Menu/add";
    }

    @RequestMapping("/menuAdd")
    public String add(Menu menu, Model model) {
        System.out.println("保存菜单"+menu);
        menuService.save(menu);
        return "redirect:/menuMange";
    }

    @RequestMapping("/menu/{id}/delete")
    public String delete(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response,Model model) throws ServletException, IOException {
        menuService.delete(id);
        Menu menu = menuService.findById(id);
        model.addAttribute("menu",menu);
        String c="<script type='text/javascript'> alert('删除成功')</script>";
        doPost(request,response,c);
        return "redirect:/menuMange";
    }

    @RequestMapping("/menu/{id}/toUpdate")
    public String toEdit(@PathVariable Long id, Model model) {
        Menu menu = menuService.findById(id);
        System.out.println("编辑菜单"+menu.toString());
        model.addAttribute("menu",menu);
        return "Menu/edit";
    }

    @RequestMapping("/searchMenu")
    public String search(@RequestParam String menuname, Model model){
        model.addAttribute("menu", menuService.searchByName(menuname));
        return "Menu/index";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response, String contents)throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(contents);
        out.println("</HTML>");
        out.flush();
        out.close();
        request.getRequestDispatcher("bill.jsp");
    }

}
