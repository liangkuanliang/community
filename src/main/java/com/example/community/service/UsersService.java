package com.example.community.service;

import com.example.community.model.Users;

public interface UsersService {
    Users selectUser();
    void insertuUser(Users users);

    Users findByToken(String token);
    Users findByAccountId( String accountId);
}
