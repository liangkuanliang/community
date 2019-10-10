package com.example.community.controller;

import com.example.community.dto.AccessTokenDTO;
import com.example.community.dto.GithubUser;
import com.example.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                            @RequestParam(name="state")String state){
        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setState(state);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id("Iv1.81ddcf5b0e8bf454");
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setClient_secret("df62f29316904e0d134b5e7b1cc230e93ccb9c34");
        String token=githubProvider.GetToken(accessTokenDTO);
        GithubUser githubUser=githubProvider.getGithubUser(token);
        System.out.print("githubUser为："+githubUser);
        return "index";

    }
}
