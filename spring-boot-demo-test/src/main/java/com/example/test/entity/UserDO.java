package com.example.test.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author fengdan
 */
@Data
@Accessors(chain = true)
public class UserDO {
    private Long id;
    private String userName;
    private String password;
    private Integer age;
}
