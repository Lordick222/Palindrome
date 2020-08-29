package ru.veselkov.converter;

import ru.veselkov.dao.user.UserModel;
import ru.veselkov.service.user.UserDTO;

public class UserModelToUserDtoConverter implements Converter<UserModel, UserDTO> {
    @Override
    public UserDTO convert(UserModel source) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(source.getId());
        userDTO.setLogin(source.getLogin());
        userDTO.setScores(source.getScores());
        return userDTO;
    }
}
