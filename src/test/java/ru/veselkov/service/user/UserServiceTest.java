package ru.veselkov.service.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.veselkov.converter.Converter;
import ru.veselkov.dao.user.UserDao;
import ru.veselkov.dao.user.UserModel;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserService subj;
    @Mock
    UserDao userDao;
    @Mock
    Converter<UserModel, UserDTO> userModelToUserDtoConverter;


    @Test
    public void createUser() {
        UserModel userModel = new UserModel();
        userModel.setId(0L);
        userModel.setPassword("password");
        userModel.setLogin("login");
        userModel.setScores(BigDecimal.ZERO);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(0L);
        userDTO.setLogin("login");
        userDTO.setScores(BigDecimal.ZERO);

        when(userDao.insertUser("login", "password")).thenReturn(userModel);
        when(userModelToUserDtoConverter.convert(userModel)).thenReturn(userDTO);

        UserDTO userDTOTest = subj.createUser("login", "password");

        assertEquals(userDTOTest, userDTO);
        verify(userDao, times(1)).insertUser("login", "password");
        verify(userModelToUserDtoConverter, times(1)).convert(userModel);
    }

    @Test
    public void notCreateUser() {
        when(userDao.insertUser("login", "password")).thenReturn(null);
        UserDTO userDTOTest = subj.createUser("login", "password");

        assertNull(userDTOTest);
        verify(userDao, times(1)).insertUser("login", "password");
        verify(userModelToUserDtoConverter, times(0)).convert(new UserModel());
    }

    @Test
    public void addScores() {
        when(userDao.addScores(1L, BigDecimal.ZERO, "someString")).thenReturn(new BigDecimal(15));

        BigDecimal test = subj.addScores(1L, BigDecimal.ZERO, "someString");

        assertEquals(test, new BigDecimal(15));
    }
}