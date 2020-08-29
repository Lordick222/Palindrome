package ru.veselkov.service.user;

import ru.veselkov.converter.Converter;
import ru.veselkov.dao.user.UserDao;
import ru.veselkov.dao.user.UserModel;

import java.math.BigDecimal;

public class UserService {
    private final UserDao userDao;
    private final Converter<UserModel, UserDTO> userModelToUserDtoConverter;

    public UserService(UserDao userDao, Converter<UserModel, UserDTO> userModelToUserDtoConverter) {
        this.userDao = userDao;
        this.userModelToUserDtoConverter = userModelToUserDtoConverter;
    }

    public UserDTO createUser(String login, String password) {
        UserModel userModel = userDao.insertUser(login, password);
        if (userModel == null) return null;
        return userModelToUserDtoConverter.convert(userModel);
    }

    public BigDecimal addScores(Long id, BigDecimal addScore, String string) {
        return userDao.addScores(id, addScore, string);
    }
}
