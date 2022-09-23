package com.example.test.controller;

import com.example.test.entity.UserDO;
import com.example.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author fengdan
 */
@Sql(scripts = "classpath:sql/create_tables.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:sql/insert.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:sql/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    private final MockMvc mockMvc;
    private final UserService userService;

    @Autowired
    public UserControllerTest(MockMvc mockMvc, UserService userService) {
        this.mockMvc = mockMvc;
        this.userService = userService;
    }

    @Test
    void testGetUser() throws Exception {
        // 模拟 service层 数据
        Mockito.when(userService.getByIdUser(2L)).thenReturn(
                new UserDO().setId(2L).setUserName("username:1").setPassword("password:1").setAge(30)
        );

        // 查询用户
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/user/get?id=1"));
        // 校验响应状态码 响应状态码 200
        result.andExpect(MockMvcResultMatchers.status().isOk());
        // 校验响应内容方式一：直接全部匹配
        result.andExpect(MockMvcResultMatchers.content().json("{\n" +
                "    \"id\": 2,\n" +
                "    \"username\": \"username:1\",\n" +
                "    \"password\": \"password:1\",\n" +
                "    \"age\": \"30\"\n" +
                "}", true));
        //  校验响应内容方式二：逐个字段匹配
        result.andExpect(MockMvcResultMatchers.jsonPath("id", IsEqual.equalTo(1L)));
        result.andExpect(MockMvcResultMatchers.jsonPath("username", IsEqual.equalTo("username:1")));
        result.andExpect(MockMvcResultMatchers.jsonPath("password", IsEqual.equalTo("password:1")));
    }
}
