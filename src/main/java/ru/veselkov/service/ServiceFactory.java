package ru.veselkov.service;

import ru.veselkov.dao.DaoFactory;
import ru.veselkov.service.operations.PalindromeService;
import ru.veselkov.service.operations.StringTreatment;
import ru.veselkov.service.user.UserService;

public class ServiceFactory {
    private static PalindromeService palindromeService;
    private static PlayGame playGame;
    private static StringTreatment stringTreatment;
    private static UserService userService;
    private static LeaderBoardService leaderBoardService;

    public static PalindromeService getPalindromeService() {
        if (palindromeService == null) {
            palindromeService = new PalindromeService();
        }
        return palindromeService;
    }

    public static StringTreatment getStringTreatment() {
        if (stringTreatment == null) {
            stringTreatment = new StringTreatment();
        }
        return stringTreatment;
    }

    public static UserService getUserService() {
        if (userService == null) {
            userService = new UserService(DaoFactory.getUserDao(), DaoFactory.getUserModelUserDTOConverter());
        }
        return userService;
    }

    public static PlayGame getPlayGame() {
        if (playGame == null) {
            playGame = new PlayGame(ServiceFactory.getUserService(), ServiceFactory.getPalindromeService(), ServiceFactory.getStringTreatment());
        }
        return playGame;
    }

    public static LeaderBoardService getLeaderBoardService() {
        if (leaderBoardService == null) {
            leaderBoardService = new LeaderBoardService(DaoFactory.getLeaderBoardDao(), DaoFactory.getUserModelUserDTOConverter());
        }
        return leaderBoardService;
    }
}
