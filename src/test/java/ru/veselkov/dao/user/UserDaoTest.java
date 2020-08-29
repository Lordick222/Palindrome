package ru.veselkov.dao.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.veselkov.dao.guessedWords.GuessedWordsDao;
import ru.veselkov.dao.leaderBoard.LeaderBoardDao;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

    @InjectMocks
    UserDao subj;
    @Mock
    GuessedWordsDao guessedWordsDao;
    @Mock
    LeaderBoardDao leaderBoardDao;

    @Test
    public void insertUser() {
        UserModel userModel = new UserModel();
        userModel.setId(0L);
        userModel.setPassword("password");
        userModel.setLogin("login");
        userModel.setScores(BigDecimal.ZERO);
        UserModel userModelTest = subj.insertUser("login", "password");
        assertEquals(userModelTest, userModel);
        assertEquals(subj.getUserModelHashSet().size(), 1);
    }

    @Test
    public void insertUserNull() {
        UserModel userModelTest = subj.insertUser(null, null);
        assertNull(userModelTest);
    }
}