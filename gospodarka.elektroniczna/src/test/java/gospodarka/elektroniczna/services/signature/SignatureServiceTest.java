package gospodarka.elektroniczna.services.signature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import gospodarka.elektroniczna.dao.sgnature.ISignatureDao;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class SignatureServiceTest {
    @Mock
    private ISignatureDao dao;
    @InjectMocks
    private SignatureService sut;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldReturnCurentDateWithOneIfDaoReturNull() throws Exception {
        // given
        when(dao.getLastSignature()).thenReturn(null);
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

}
