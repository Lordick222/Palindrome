package ru.veselkov.dao.guessedWords;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import ru.veselkov.dao.user.UserModel;

import java.util.HashSet;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GuessedWordsDaoTest {


    @Test
    public void addString() {
        UserModel userModel = new UserModel();
        userModel.setId(1L);
        GuessedWordsDao guessedWordsDao = new GuessedWordsDao();
        guessedWordsDao.putNewUserModel(userModel);
        boolean test = guessedWordsDao.addString(1L, "topot");
        assertTrue(test);
        assertEquals(guessedWordsDao.getGuessedWords().size(), 1);
    }

    @Test
    public void addStringDublicate() {
        UserModel userModel = new UserModel();
        userModel.setId(1L);
        GuessedWordsDao guessedWordsDao = new GuessedWordsDao();
        guessedWordsDao.putNewUserModel(userModel);
        guessedWordsDao.addString(1L, "topot");
        boolean test = guessedWordsDao.addString(1L, "topot");
        assertFalse(test);
        assertEquals(guessedWordsDao.getGuessedWords().size(), 1);
    }

    @Test
    public void addStringNull() {
        GuessedWordsDao guessedWordsDao = new GuessedWordsDao();
        boolean test = guessedWordsDao.addString(1L, null);
        assertFalse(test);
    }


    @Test
    public void getStringSetById() {
        UserModel userModel = new UserModel();
        userModel.setId(1L);
        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add("topot");
        GuessedWordsDao guessedWordsDao = new GuessedWordsDao();
        guessedWordsDao.putNewUserModel(userModel);
        guessedWordsDao.addString(1L, "topot");
        guessedWordsDao.getStringSetById(1L);
        assertEquals(guessedWordsDao.getStringSetById(1L), stringHashSet);
    }
}