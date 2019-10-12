package com.example.community.service.Impl;

import com.example.community.dto.QuestionDTO;
import com.example.community.mapper.QuestionMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.Users;
import com.example.community.service.QuesttionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuesttionServiceImpl implements QuesttionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public void insertQuestion(Question question) {
        questionMapper.insertQuestion(question);
        }

    @Override
    public List<QuestionDTO> selectQuestion() {
        List<Question> questions=questionMapper.selectQuestion();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for (Question question:questions){
            Users users=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUsers(users);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }

}
