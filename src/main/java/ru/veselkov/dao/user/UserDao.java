package ru.veselkov.dao.user;

import ru.veselkov.dao.guessedWords.GuessedWordsDao;
import ru.veselkov.dao.leaderBoard.LeaderBoardDao;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class UserDao {
    private final HashSet<UserModel> userModelHashSet;
    private Long AUTO_INCREMENT_ID = 0L;
    private final GuessedWordsDao guessedWordsDao;
    private final LeaderBoardDao leaderBoardDao;

    public UserDao(GuessedWordsDao guessedWordsDao, LeaderBoardDao leaderBoardDao) {
        this.guessedWordsDao = guessedWordsDao;
        this.leaderBoardDao = leaderBoardDao;
        this.userModelHashSet = new HashSet<>();
    }


    public UserModel insertUser(String login, String password) {
        if (login == null || password == null) return null;

        UserModel userModel = new UserModel();
        userModel.setId(AUTO_INCREMENT_ID);
        userModel.setLogin(login);
        userModel.setPassword(password);
        userModel.setScores(BigDecimal.ZERO);

        if (checkLoginDuplicate(userModelHashSet, login)) {
            userModelHashSet.add(userModel);
            guessedWordsDao.putNewUserModel(userModel);
            AUTO_INCREMENT_ID++;
            return userModel;
        } else {
            return null;
        }
    }

    public BigDecimal addScores(Long id, BigDecimal addScores, String string) {
        UserModel userModel = findUserById(id);
        if (userModel == null) {
            return null;
        } else {
            if (guessedWordsDao.addString(id, string)) {
                userModel.setScores(userModel.getScores().add(addScores));
                leaderBoardDao.checkForLeaderBoardAffiliation(userModel);
                return userModel.getScores();
            }
        }
        return null;
    }

    private UserModel findUserById(Long id) {
        for (UserModel userModel : userModelHashSet) {
            if (userModel.getId().equals(id)) {
                return userModel;
            }
        }
        return null;
    }

    public HashSet<UserModel> getUserModelHashSet() {
        return new HashSet<>(userModelHashSet);
    }

    private boolean checkLoginDuplicate(Set<UserModel> userModelHashSet, String login) {
        for (UserModel userModel : userModelHashSet) {
            if (userModel.getLogin().equals(login)) {
                return false;
            }
        }
        return true;
    }
}
