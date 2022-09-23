package com.example.test.service;

import com.example.test.entity.UserDO;
import com.example.test.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

/**
 * @author fengdan
 */
@Slf4j
@Sql(scripts = "classpath:sql/create_tables.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:sql/insert.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:sql/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@SpringBootTest
class UserServiceTest {
    private final UserService userService;

    @Autowired
    public UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    void testGetByIdUser() {
        UserDO user = userService.getByIdUser(2L);
        Assertions.assertEquals(2L, user.getId(), "编号不匹配");
        Assertions.assertEquals("username:1", user.getUserName(), "用户名不匹配");
        Assertions.assertEquals("password:1", user.getPassword(), "密码不匹配");
    }
}
