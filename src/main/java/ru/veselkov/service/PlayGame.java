package ru.veselkov.service;

import ru.veselkov.service.operations.PalindromeService;
import ru.veselkov.service.operations.StringTreatment;
import ru.veselkov.service.user.UserDTO;
import ru.veselkov.service.user.UserService;

import java.math.BigDecimal;

public class PlayGame {
    private final UserService userService;
    private final PalindromeService palindromeService;
    private final StringTreatment stringTreatment;

    public PlayGame(UserService userService, PalindromeService palindromeService, StringTreatment stringTreatment) {
        this.userService = userService;
        this.palindromeService = palindromeService;
        this.stringTreatment = stringTreatment;
    }

    public BigDecimal playGame(UserDTO userDTO, String string) {
        String stringWithOutUnnecessaryCharacters = stringTreatment.refactorString(string);
        if (string == null || userDTO == null) return null;
        if (palindromeService.isPalindrome(stringWithOutUnnecessaryCharacters)) {
            BigDecimal addScores = new BigDecimal(stringWithOutUnnecessaryCharacters.length());
            return userService.addScores(userDTO.getId(), addScores, stringWithOutUnnecessaryCharacters);
        } else {
            return null;
        }
    }
}
