package ru.veselkov.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.veselkov.converter.Converter;
import ru.veselkov.dao.leaderBoard.LeaderBoardDao;
import ru.veselkov.dao.user.UserModel;
import ru.veselkov.service.user.UserDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LeaderBoardServiceTest {

    @InjectMocks
    LeaderBoardService subj;
    @Mock
    Converter<UserModel, UserDTO> userModelToUserDtoConverter;
    @Mock
    LeaderBoardDao leaderBoardDao;


    @Test
    public void printLeaderBoard() {
        List<UserModel> userModelList = new ArrayList<>();
        UserModel userModel = new UserModel();
        userModel.setId(0L);
        userModelList.add(userModel);

        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(0L);
        userDTOList.add(userDTO);


        when(leaderBoardDao.getLeaderBoard()).thenReturn(userModelList);
        when(userModelToUserDtoConverter.convert(userModel)).thenReturn(userDTO);

        List<UserDTO> test = subj.printLeaderBoard();

        assertEquals(test, Collections.singletonList(userDTO));
        verify(userModelToUserDtoConverter, times(1)).convert(userModel);
    }
}