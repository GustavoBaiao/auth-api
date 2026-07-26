package com.gustavobaiao.auth_api.mapper;

import com.gustavobaiao.auth_api.dto.request.CreateUserRequestDTO;
import com.gustavobaiao.auth_api.dto.response.UserResponseDTO;
import com.gustavobaiao.auth_api.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "userDTO.name")
    @Mapping(target = "email", source = "userDTO.email")
    @Mapping(target = "termsAccepted", source = "userDTO.termsAccepted")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    UserEntity toEntity(CreateUserRequestDTO userDTO);

    @Mapping(target = "id", source = "userEntity.id")
    @Mapping(target = "name", source = "userEntity.name")
    @Mapping(target = "email", source = "userEntity.email")
    @Mapping(target = "termsAccepted", source = "userEntity.termsAccepted")
    UserResponseDTO toDto(UserEntity userEntity);
}
