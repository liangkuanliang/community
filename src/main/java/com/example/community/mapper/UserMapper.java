package com.example.community.mapper;

import com.example.community.model.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from users")
    public Users selectUser();

    @Insert("INSERT INTO users (name,accountId,token,gmtCreate,gmtmodified) VALUES (#{name},#{accountId},#{token},#{gmtCreate},#{gmtmodified})")
    public void insertuUser(Users users);

    @Select("select * from users where token=#{token}")
    Users findByToken(@Param("token") String token);

    @Select("select * from users where accountId=#{accountId}")
    Users findByAccountId(@Param("accountId") String accountId);
}
