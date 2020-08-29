package ru.veselkov.dao.leaderBoard;

import ru.veselkov.dao.user.UserModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeaderBoardDao {
    private final List<UserModel> leaderBoard;

    public LeaderBoardDao() {
        this.leaderBoard = new ArrayList<>();
    }


    public void checkForLeaderBoardAffiliation(UserModel userModel) {
        if (!(leaderBoard.contains(userModel))) {
            if (leaderBoard.size() > 4) {
                leaderBoard.set(0, userModel);
            } else {
                leaderBoard.add(userModel);
            }
        }
        leaderBoard.sort(Comparator.comparing(UserModel::getScores));
    }

    public List<UserModel> getLeaderBoard() {
        return new ArrayList<>(leaderBoard);
    }
}
