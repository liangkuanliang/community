package com.example.community.controller;

import com.example.community.mapper.UserMapper;
import com.example.community.model.Users;
import com.example.community.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("token")){
                String token=cookie.getValue();
                Users users=usersService.findByToken(token);
                if (users!=null){
                    System.out.print(users);
                    request.getSession().setAttribute("user",users);
                }
                break;
            }

        }
        return "index";
    }


}
