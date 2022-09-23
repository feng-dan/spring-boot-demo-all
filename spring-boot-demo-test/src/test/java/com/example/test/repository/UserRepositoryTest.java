package com.example.test.repository;

import com.example.test.entity.UserDO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

/**
 * @author fengdan
 */

@SpringBootTest
class UserRepositoryTest {
    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Sql(scripts = "classpath:sql/create_tables.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/insert.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    @DisplayName("根据用户编号查询")
    void selectByIdTest() {
        UserDO user = userRepository.selectById(2L);
        // 校验结果
        Assertions.assertEquals(2, user.getId(), "编号不匹配");
        Assertions.assertEquals("username:1", user.getUserName(), "用户名不匹配");
        Assertions.assertEquals("password:1", user.getPassword(), "密码不匹配");
    }
}
