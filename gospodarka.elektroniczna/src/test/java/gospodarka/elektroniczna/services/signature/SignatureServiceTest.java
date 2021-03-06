package gospodarka.elektroniczna.services.signature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gospodarka.elektroniczna.dao.signature.ISignatureDao;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import pl.wkr.fluentrule.api.FluentExpectedException;


public class SignatureServiceTest {
    @Rule
    public FluentExpectedException exception = FluentExpectedException.none();
    @Mock
    private ISignatureDao dao;
    @InjectMocks
    private SignatureService sut;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnCurentDateWithOneIfDaoReturnNull() throws Exception {
        // given
        when(dao.getLastSignature()).thenReturn(null);
        when(dao.getSignaturesNumber()).thenReturn(0);
        String expectedSignature = getFirstPartOfSignature() + "1";
        
        // when
        String signature = sut.createNewSingature();
        
        // then
        assertEquals(expectedSignature, signature);
    }
    
    @Test
    public void shouldReturnCurentDateWithOneIfDaoReturnEmptyString() throws Exception {
        // given
        when(dao.getLastSignature()).thenReturn("");
        when(dao.getSignaturesNumber()).thenReturn(0);
        String expectedSignature = getFirstPartOfSignature() + "1";
        
        // when
        String signature = sut.createNewSingature();
        
        // then
        assertEquals(expectedSignature, signature);
    }
    
    @Test
    public void shouldReturnCurentDateWithOneIfDaoReturnDateWithObsoleteMonth() throws Exception {
        // given
        GregorianCalendar calendar = new GregorianCalendar();
        when(dao.getSignaturesNumber()).thenReturn(1);
        when(dao.getLastSignature()).thenReturn(calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH) + "/23");
        String expectedSignature = getFirstPartOfSignature() + "1";
        
        // when
        String signature = sut.createNewSingature();
        
        // then
        assertEquals(expectedSignature, signature);
    }
    
    @Test
    public void shouldReturnCurentDateWithOneIfDaoReturnDateWithObsoleteYear() throws Exception {
        // given
        GregorianCalendar calendar = new GregorianCalendar();
        when(dao.getSignaturesNumber()).thenReturn(1);
        when(dao.getLastSignature()).thenReturn((calendar.get(Calendar.YEAR) - 2) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/23");
        String expectedSignature = getFirstPartOfSignature() + "1";
        
        // when
        String signature = sut.createNewSingature();
        
        // then
        assertEquals(expectedSignature, signature);
    }
    
    @Test
    public void shouldReturnIncrementLastPartIfDaoReturnCurrentDate() throws Exception {
        // given
        GregorianCalendar calendar = new GregorianCalendar();
        when(dao.getSignaturesNumber()).thenReturn(1);
        when(dao.getLastSignature()).thenReturn((calendar.get(Calendar.YEAR)) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/56");
        String expectedSignature = getFirstPartOfSignature() + "57";
        
        // when
        String signature = sut.createNewSingature();
        
        // then
        assertEquals(expectedSignature, signature);
    }
    
    private String getFirstPartOfSignature() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.get(GregorianCalendar.YEAR) + "/" + (calendar.get(GregorianCalendar.MONTH) + 1) + "/";
    }

    @Test
    public void shouldTrowWrongNumberOfLastSignatureExceptionIfInTableAreMoreThenOneSignature() throws Exception {
        // given
        exception.expect(WrongNumberOfLastSignatureException.class);
        when(dao.getSignaturesNumber()).thenReturn(2);
        
        // when
        sut.createNewSingature();
        
        // then
    }

}
