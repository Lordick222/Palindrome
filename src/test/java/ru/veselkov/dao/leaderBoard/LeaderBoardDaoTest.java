package ru.veselkov.dao.leaderBoard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import ru.veselkov.dao.user.UserModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LeaderBoardDaoTest {

    @Test
    public void checkForLeaderBoardAffiliation() {
        LeaderBoardDao leaderBoardDao = new LeaderBoardDao();
        List<UserModel> userModelList = new ArrayList<>();
        UserModel userModel1 = new UserModel();
        userModel1.setId(1L);
        userModel1.setScores(new BigDecimal(1));

        UserModel userModel2 = new UserModel();
        userModel2.setId(2L);
        userModel2.setScores(new BigDecimal(2));

        UserModel userModel3 = new UserModel();
        userModel3.setId(3L);
        userModel3.setScores(new BigDecimal(3));

        UserModel userModel4 = new UserModel();
        userModel4.setId(4L);
        userModel4.setScores(new BigDecimal(4));

        UserModel userModel5 = new UserModel();
        userModel5.setId(5L);
        userModel5.setScores(new BigDecimal(5));

        UserModel userModel6 = new UserModel();
        userModel6.setId(6L);
        userModel6.setScores(new BigDecimal(6));

        userModelList.add(userModel2);
        userModelList.add(userModel3);
        userModelList.add(userModel4);
        userModelList.add(userModel5);
        userModelList.add(userModel6);

        leaderBoardDao.checkForLeaderBoardAffiliation(userModel1);
        leaderBoardDao.checkForLeaderBoardAffiliation(userModel2);
        leaderBoardDao.checkForLeaderBoardAffiliation(userModel3);
        leaderBoardDao.checkForLeaderBoardAffiliation(userModel4);
        leaderBoardDao.checkForLeaderBoardAffiliation(userModel5);
        leaderBoardDao.checkForLeaderBoardAffiliation(userModel6);

        assertEquals(leaderBoardDao.getLeaderBoard(), userModelList);
    }
}