package com.example.community.service.Impl;

import com.example.community.dto.PageinationDTO;
import com.example.community.dto.QuestionDTO;
import com.example.community.mapper.QuestionMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.Users;
import com.example.community.service.QuesttionService;
import com.example.community.utils.PageUtils;
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
    public PageinationDTO selectQuestion(Integer page, Integer size) {
        Integer offtest=size*(page-1);
        List<Question> questions=questionMapper.selectQuestion(offtest,size);
        List<QuestionDTO> questionDTOList=new ArrayList<>();

        PageinationDTO pageinationDTO=new PageinationDTO();
        for (Question question:questions){
            Users users=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUsers(users);
            questionDTOList.add(questionDTO);
        }
        pageinationDTO.setQuestions(questionDTOList);
        Integer count=questionMapper.selectCount();
        pageinationDTO.setPageination(count,page,size);
        return pageinationDTO;
    }

}
