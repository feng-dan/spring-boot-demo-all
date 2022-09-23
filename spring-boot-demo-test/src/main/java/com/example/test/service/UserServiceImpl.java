package com.example.test.service;

import com.example.test.entity.UserDO;
import com.example.test.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author fengdan
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDO getByIdUser(Long userId) {
        UserDO userDO = userRepository.selectById(userId);
        if (ObjectUtils.isEmpty(userDO)) {
            UserDO user = new UserDO();
            user.setId(700L);
            user.setUserName("秦王");
            user.setPassword("123456");
            user.setAge(34);
            return user;
        }
        return userDO;
    }
}
