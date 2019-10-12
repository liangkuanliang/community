package com.example.community.mapper;

import com.example.community.dto.QuestionDTO;
import com.example.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface QuestionMapper {
    @Select("select * from question")
     List<Question> selectQuestion();

    @Insert("INSERT INTO question (title,description,gmtcreate,gmtmodified,creator,tag) VALUES (#{title},#{description},#{gmtcreate},#{gmtmodified},#{creator},#{tag})")
     void insertQuestion(Question question);
}
