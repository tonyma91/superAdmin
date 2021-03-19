package com.cvworld.nanjing.controller.AdminController;

import com.cvworld.nanjing.bean.Organ;
import com.cvworld.nanjing.bean.User;
import com.cvworld.nanjing.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class OrganController {

    @Autowired
    private OrganService organService;

    //跳转到新增页面
    @RequestMapping("toAddOrgan")
    public String toNodeAdd(Model model){
        model.addAttribute("organ",new Organ());
        return "Node/add";
    }

    //执行新增
    @RequestMapping("/organAdd")
    public String add(@Valid Organ organ, HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        organService.saveOrgan(organ);
        return "redirect:/nodeMange";
    }

    //模糊查询
    @GetMapping("/searchNode")
    public String search(@PageableDefault(size = 4,sort = {"id"},direction = Sort.Direction.ASC) Pageable pageable,
                         Model model, @RequestParam("organname") String organname){
        model.addAttribute("page",organService.listOrgan("%"+organname+"%",pageable));
        model.addAttribute("organname",organname);
        System.out.println(organname);
        return "Node/index";
    }

    //跳转到更新页面
    @RequestMapping("/organ/{id}/toUpdate")
    public String update(@PathVariable Long id, Model model){
        Organ organ = organService.findById(id);
        model.addAttribute("organ",organ);
        return "Node/edit";
    }

    //删除操作
    @RequestMapping("/organ/{id}/delete")
    public String delete(@PageableDefault(size = 4,sort = {"id"},direction = Sort.Direction.ASC) Pageable pageable,
                         @PathVariable Long id,Model model,HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {

        organService.deleteById(id);
        model.addAttribute("page",organService.findAll(pageable));
        String c="<script type='text/javascript'> alert('删除成功')</script>";
        doPost(request,response,c);
        return "Node/index";
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
