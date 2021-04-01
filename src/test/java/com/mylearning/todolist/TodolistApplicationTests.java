package com.mylearning.todolist;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mylearning.todolist.model.TodoItem;
import com.mylearning.todolist.repo.TodoItems;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TodolistApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() {

	}

	@Test
	void todoPostRouteTest() throws Exception{
		TodoItem todoItem = new TodoItem();

		todoItem.setTitle("Test Task");
		todoItem.setDescription("Creating a task for tests");
		todoItem.setDone(false);

		mockMvc.perform(post("/todo")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(todoItem)))
				.andExpect(status().isOk());
	}

}
