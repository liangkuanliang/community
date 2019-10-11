package com.example.community.controller;

import com.example.community.dto.AccessTokenDTO;
import com.example.community.dto.GithubUser;
import com.example.community.model.Users;
import com.example.community.provider.GithubProvider;
import com.example.community.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String Client_id;

    @Value("${github.redirect.uri}")
    private String Redirect_uri;

    @Value("${github.client.secret}")
    private String Client_secret;

    @Autowired
    private UsersService usersService;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name="state")String state,
                           HttpServletRequest request,
                           HttpServletResponse response){
        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setState(state);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(Client_id);
        accessTokenDTO.setRedirect_uri(Redirect_uri);
        accessTokenDTO.setClient_secret(Client_secret);
        String accesstoken=githubProvider.GetToken(accessTokenDTO);
        GithubUser githubUser=githubProvider.getGithubUser(accesstoken);
        if (githubUser!=null){
            Users users=new Users();
            String token=UUID.randomUUID().toString();
            users.setToken(token);
            users.setName(githubUser.getName());
            users.setAccountId(githubUser.getId());
            users.setGmtCreate(String.valueOf(System.currentTimeMillis()));
            users.setGmtmodified(users.getGmtCreate());
            usersService.insertuUser(users);

            response.addCookie(new Cookie("token",token));
            /*request.getSession().setAttribute("user",githubUser);*/
            return "redirect:/";
        }else {
            return "redirect:/";

        }
    }
}
