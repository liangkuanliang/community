package com.example.community.provider;

import com.alibaba.fastjson.JSON;
import com.example.community.dto.AccessTokenDTO;
import com.example.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {

   public String GetToken(AccessTokenDTO accessTokenDTO){
        MediaType json = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(json, JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string= response.body().string();
                String token=string.split("&")[0].split("=")[1];
                return token;

            } catch (IOException e) {
                e.printStackTrace();
            }
     return null;

    }
    public GithubUser getGithubUser(String token){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+token)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string= response.body().string();
            GithubUser parse = JSON.parseObject(string,GithubUser.class);
            return parse;
        } catch (IOException e) {
            e.printStackTrace();
        }
     return null;
    }

}
