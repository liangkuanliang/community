package com.example.community;

import com.example.community.dto.QuestionDTO;
import com.example.community.mapper.QuestionMapper;
import com.example.community.mapper.UserMapper;
import com.example.community.model.Question;
import com.example.community.model.Users;
import com.example.community.service.QuesttionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuesttionService questtionService;
	@Test
	public void contextLoads() {
		Users users=userMapper.selectUser();
		System.out.print("user为："+users.toString());
	}

	@Test
	public void questioncontextLoads() {
		List<QuestionDTO> question=questtionService.selectQuestion();
		System.out.print("user为："+question.toString());
	}

}
