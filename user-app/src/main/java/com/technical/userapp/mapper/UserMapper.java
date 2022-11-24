package com.technical.userapp.mapper;

import com.technical.userapp.dto.UserBasic;
import com.technical.userapp.model.User;
import org.mapstruct.*;

// A mapper interface that maps the User to UserBasic and vice versa.
@Mapper(componentModel = "spring", uses = {}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    @Named("basic")
    UserBasic toBasic(User user);

    User toEntity(UserBasic userBasic);
}
