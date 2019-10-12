package com.example.community.service;

import com.example.community.dto.QuestionDTO;
import com.example.community.model.Question;

import java.util.List;

public interface QuesttionService {
    void insertQuestion(Question question);
    List<QuestionDTO> selectQuestion();
}
