package ru.veselkov.dao;

import ru.veselkov.converter.Converter;
import ru.veselkov.converter.UserModelToUserDtoConverter;
import ru.veselkov.dao.guessedWords.GuessedWordsDao;
import ru.veselkov.dao.leaderBoard.LeaderBoardDao;
import ru.veselkov.dao.user.UserDao;
import ru.veselkov.dao.user.UserModel;
import ru.veselkov.service.user.UserDTO;

public class DaoFactory {
    private static Converter<UserModel, UserDTO> userModelUserDTOConverter;
    private static GuessedWordsDao guessedWordsDao;
    private static LeaderBoardDao leaderBoardDao;
    private static UserDao userDao;

    public static Converter<UserModel, UserDTO> getUserModelUserDTOConverter() {
        if (userModelUserDTOConverter == null) {
            userModelUserDTOConverter = new UserModelToUserDtoConverter();
        }
        return userModelUserDTOConverter;
    }


    public static GuessedWordsDao getGuessedWordsDao() {
        if (guessedWordsDao == null) {
            guessedWordsDao = new GuessedWordsDao();
        }
        return guessedWordsDao;
    }

    public static LeaderBoardDao getLeaderBoardDao() {
        if (leaderBoardDao == null) {
            leaderBoardDao = new LeaderBoardDao();
        }
        return leaderBoardDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao(DaoFactory.getGuessedWordsDao(),
                    DaoFactory.getLeaderBoardDao());
        }
        return userDao;
    }
}
