package com.example.community.service.Impl;

import com.example.community.mapper.UserMapper;
import com.example.community.model.Users;
import com.example.community.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Users selectUser() {
        return userMapper.selectUser();
    }

    @Override
    public void insertuUser(Users users) {
        userMapper.insertuUser(users);
    }

    @Override
    public Users findByToken(String token) {
        return userMapper.findByToken(token);
    }
}
