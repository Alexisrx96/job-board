package sv.edu.udb.www.jobboard.config;

import groovy.util.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import sv.edu.udb.www.jobboard.models.dao.AccountDao;
import sv.edu.udb.www.jobboard.models.dao.CompanyProfileDao;
import sv.edu.udb.www.jobboard.models.dao.ProfesionalProfileDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@Component
public class CustomAuthenticationSuccessHandler   implements AuthenticationSuccessHandler {



    @Autowired
    HttpSession session;

    @Autowired
    AccountDao accountDao;
    @Autowired
    ProfesionalProfileDao profesionalProfileDao;
    @Autowired
    CompanyProfileDao companyProfileDao;


    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String email = "";
        String role = "";
        if(authentication.getPrincipal() instanceof Principal) {
            email = ((Principal)authentication.getPrincipal()).getName();
            for (var auth : ((User)authentication.getPrincipal()).getAuthorities()) role = auth.getAuthority();

        }else {
            email = ((User)authentication.getPrincipal()).getUsername();
            for (var auth : ((User)authentication.getPrincipal()).getAuthorities()) role = auth.getAuthority();
        }
        role = role.replace("ROLE_","");
        final String username = "username";
        if ("ADMIN".equals(role)) {
            var admin = accountDao.getAccount(email);
            session.setAttribute(username, admin.getId());
        } else if ("COMPANY".equals(role)) {
            var company = companyProfileDao.getCompanyProfileByEmail(email);
            session.setAttribute(username, company.getName());
            session.setAttribute("id", company.getId());
        } else if ("PROFESSIONAL".equals(role)) {
            var professional = profesionalProfileDao.getProfesionalProfileByEmail(email);
            session.setAttribute(username, professional.getFirstName() + " " + professional.getLastName());
            session.setAttribute("id", professional.getId());
        }

        session.setAttribute("email",email);
        session.setAttribute("role", role);

        redirectStrategy.sendRedirect(request, response, "/");
    }
}