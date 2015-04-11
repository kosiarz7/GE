package gospodarka.elektroniczna.controllers;

import gospodarka.elektroniczna.common.beans.RedirectBean;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedirectController {
    /**
     * Bean przekierowujący zalogowanego użytkownika na opdowiednią stronę.
     */
    @Autowired
    private RedirectBean redirectBean;
    
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirectToDepartment(final Model model) {
        LoggerFactory.getLogger(RedirectController.class).error("JETEM TUTAJ!!!!");
        return redirectBean.getRedirectUrl();
    }
}
