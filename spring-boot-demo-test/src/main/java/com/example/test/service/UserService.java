package com.example.test.service;

import com.example.test.entity.UserDO;

/**
 * @author fengdan
 */
public interface UserService {
    /**
     * getByIdUser
     *
     * @param userId userId
     * @return User
     */
    UserDO getByIdUser(Long userId);
}
