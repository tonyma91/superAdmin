package com.laoma.admin.controller;

import com.laoma.admin.Verify.ImageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

    @Controller
    public class VerifyController {

        @RequestMapping(value = "/checkCode")
        public void checkCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

            Cookie[] cookies = request.getCookies();
            for (Cookie cookie:cookies){
                System.out.println("获取到cookies=----"+cookie.getName()+cookie.getValue());
            }

            //设置编码格式
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            // 设置不缓存图片
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "No-cache");
            response.setDateHeader("Expires", 0);

            // 指定生成的响应图片
            response.setContentType("image/jpeg");

             // 传入生成图像长度和宽度，还有本次会话的请求HttpServletRequest对象request
            BufferedImage image = ImageUtils.getPicture(80, 35, request);

            // 将图像输出到response输出流中，response.getOutputStream()获取response输出流
            ImageIO.write(image, "JPEG", response.getOutputStream());
        }
    }










