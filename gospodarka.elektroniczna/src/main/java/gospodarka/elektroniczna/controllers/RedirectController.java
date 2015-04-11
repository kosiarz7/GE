package gospodarka.elektroniczna.controllers;

import gospodarka.elektroniczna.common.beans.RedirectBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Kontroler przekierowywujący użytkownika na odpowiednią stronę.
 * 
 * @author Adam Kopaczewski
 *
 * Copyright © 2015 Adam Kopaczewski
 */
@Controller
public class RedirectController {
    /**
     * Bean przekierowujący zalogowanego użytkownika na opdowiednią stronę.
     */
    @Autowired
    private RedirectBean redirectBean;
    
    /**
     * Przekierowuje uzytkownika na opdowiednią stronę.
     * 
     * @param model model.
     * @return strona do przekierowania.
     */
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirectToDepartment(final Model model) {
        return redirectBean.getRedirectUrl();
    }
}
