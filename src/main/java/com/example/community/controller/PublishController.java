package com.example.community.controller;

import com.example.community.mapper.QuestionMapper;
import com.example.community.model.Question;
import com.example.community.model.Users;
import com.example.community.service.QuesttionService;
import com.example.community.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PublishController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private QuesttionService questtionService;

    @GetMapping("/publish")
    public String GetPublish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String PostPublish(@RequestParam(name = "title")String title,
                              @RequestParam(name="description")String description,
                              @RequestParam(name = "tag")String tag,
                              HttpServletRequest request,
                              Model model){

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        Users users=null;
        Cookie[] cookies=request.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("token")){
                String token=cookie.getValue();
                 users=usersService.findByToken(token);
                if (users!=null){
                    System.out.print(users);
                    request.getSession().setAttribute("user",users);
                }
                break;
            }
            }
            if (users==null){
                model.addAttribute("error","你没有登录");
                return "publish";
            }
        Question question=new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(users.getId());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        question.setGmtcreate(df.format(new Date()));
        question.setGmtmodified(df.format(new Date()));
        questtionService.insertQuestion(question);
        return "redirect:/";
    }
}
