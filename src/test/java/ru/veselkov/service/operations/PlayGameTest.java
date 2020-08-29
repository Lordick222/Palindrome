package ru.veselkov.service.operations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.veselkov.service.PlayGame;
import ru.veselkov.service.user.UserDTO;
import ru.veselkov.service.user.UserService;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PlayGameTest {

    @InjectMocks
    PlayGame subj;
    @Mock
    UserService userService;
    @Mock
    PalindromeService palindromeService;
    @Mock
    StringTreatment stringTreatment;


    @Test
    public void playGame() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        when(stringTreatment.refactorString("topot")).thenReturn("topot");
        when(palindromeService.isPalindrome("topot")).thenReturn(true);
        when(userService.addScores(1L, new BigDecimal(5), "topot")).thenReturn(new BigDecimal(5));

        BigDecimal test = subj.playGame(userDTO, "topot");

        assertEquals(test, new BigDecimal(5));
        verify(stringTreatment, times(1)).refactorString("topot");
        verify(palindromeService, times(1)).isPalindrome("topot");
        verify(userService, times(1)).addScores(1L, new BigDecimal(5), "topot");
    }

    @Test
    public void playGameUserNull() {
        BigDecimal test = subj.playGame(null, "topot");

        assertNull(test);
        verify(stringTreatment, times(1)).refactorString("topot");
    }

    @Test
    public void playGameStringNull() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        BigDecimal test = subj.playGame(userDTO, null);

        assertNull(test);
    }

}