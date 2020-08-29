package ru.veselkov.service.operations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StringTreatmentTest {

    @InjectMocks
    StringTreatment subj;

    @Test
    public void checkString() {
        String test1 = "  E \n j  k   \t  ";
        String res = subj.refactorString(test1);
        assertNotNull(res);
        assertEquals(res, "ejk");
    }

    @Test
    public void checkStringForNull() {
        String res = subj.refactorString(null);
        assertNull(res);
    }
}