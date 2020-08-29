package ru.veselkov.service.operations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeServiceTest {

    @InjectMocks
    PalindromeService subj;

    @Test
    public void isPalindrome() {
        String test1 = "topot";
        boolean res = subj.isPalindrome(test1);
        assertTrue(res);
    }

    @Test
    public void notPalindrome() {
        String test = "someWord";
        boolean res = subj.isPalindrome(test);
        assertFalse(res);

        test = "1word";
        res = subj.isPalindrome(test);
        assertFalse(res);

        test = "a/an.s";
        res = subj.isPalindrome(test);
        assertFalse(res);
    }
}