package gospodarka.elektroniczna.controllers.hr;

import gospodarka.elektroniczna.annotations.InjectLogger;
import gospodarka.elektroniczna.dto.RoleDto;
import gospodarka.elektroniczna.dto.UserDto;
import gospodarka.elektroniczna.dto.hr.SickLeave;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

/**
 * Zwolnienie chorobowe
 * 
 * @author iblis
 *
 */
public class SickLeaveFlow implements Serializable {

    private static final long serialVersionUID = 1L;
    @InjectLogger
    private static final Logger LOGGER = Logger.getLogger(SickLeaveFlow.class.getCanonicalName());

    public boolean submitSickLeave(SickLeave sickLeave, UserDto user) {
        LOGGER.info("submitSickLeave: "+ sickLeave);
        return true;
    }

    public List<SickLeave> getSickLeaves() {
        ArrayList<SickLeave> sickLeaves = new ArrayList<SickLeave>();

        UserDto us1 = new UserDto();
        List<RoleDto> roles = new ArrayList<RoleDto>();
        RoleDto role = new RoleDto();
        role.setName("TESTOWA_ROLA");
        roles.add(role);
        us1.setName("Jan");
        us1.setSurname("Kowalski");
        us1.setRoles(roles);

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(GregorianCalendar.DAY_OF_YEAR, -1);

        Date from1 = gregorianCalendar.getTime();
        gregorianCalendar.set(GregorianCalendar.DAY_OF_YEAR, 14);
        Date to1 = gregorianCalendar.getTime();
        // sickLeaves.add(new SickLeave(new UserData(us1), from1, to1));
        LOGGER.info("getSickLeaves: "+ sickLeaves.size());
        return sickLeaves;
    }
}
