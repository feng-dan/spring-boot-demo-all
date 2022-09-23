package com.example.test.convert;

import com.example.test.controller.vo.UserVO;
import com.example.test.entity.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author fengdan
 */
@Mapper(componentModel = "spring")
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserVO toUserVo(UserDO userDO);
}
