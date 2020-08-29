package ru.veselkov.dao.guessedWords;

import ru.veselkov.dao.user.UserModel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GuessedWordsDao {
    private final HashMap<Long, HashSet<String>> guessedWords = new HashMap<Long, HashSet<String>>();

    public HashMap<Long, HashSet<String>> getGuessedWords() {
        return new HashMap<>(guessedWords);
    }

    public void putNewUserModel(UserModel userModel) {
        guessedWords.put(userModel.getId(), new HashSet<>());
    }

    public boolean addString(Long id, String string) {
        if (id == null || string == null) return false;
        Set<String> stringSet = getStringSetById(id);
        if (stringSet == null) {
            return false;
        } else {
            return getStringSetById(id).add(string);
        }
    }

    public Set<String> getStringSetById(Long id) {
        return guessedWords.get(id);
    }
}
