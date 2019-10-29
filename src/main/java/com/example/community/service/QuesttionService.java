package com.example.community.service;

import com.example.community.dto.PageinationDTO;
import com.example.community.model.Question;

public interface QuesttionService {
    void insertQuestion(Question question);
    PageinationDTO selectQuestion(Integer page, Integer size);
}
