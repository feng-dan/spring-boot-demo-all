package com.example.test.repository;

import com.example.test.entity.UserDO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author fengdan
 */
@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserDO selectById(Long id) {
        return jdbcTemplate.queryForObject("SELECT `id`, `username`, `password`,`age` FROM `t_user` WHERE `id` = ?",
                new BeanPropertyRowMapper<>(UserDO.class), id);
    }

}
