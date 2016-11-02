package f4.web.security;

import f4.web.dao.StaffDao;
import f4.web.dao.TeacherDao;
import f4.web.entity.Staff;
import f4.web.entity.Teacher;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * Created by l on 2016/11/2.
 */
@Component
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger log = Logger.getLogger(LoginAuthenticationSuccessHandler.class);

    @Autowired
    private StaffDao staffDao;

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        HttpSession session = httpServletRequest.getSession();
        UserDetails user = (UserDetails) authentication.getPrincipal();
        Staff staff = new Staff();
        staff.setUsername(user.getUsername());
        Staff staffP = staffDao.selectOne(staff);
        if (staffP != null) {
            log.debug("================================================================");
            log.debug(user.getUsername());
            log.debug(staffP.getName());
            log.debug("================================================================");
            session.setAttribute("USER", staffP);
        }
        Teacher teacher = new Teacher();
        teacher.setUsername(user.getUsername());
        Teacher teacherP = teacherDao.selectOne(teacher);
        if (teacherP != null) {
            log.debug("------------------------------------------------------");
            log.debug(teacherP.getName());
            log.debug("------------------------------------------------------");
            session.setAttribute("USER", teacherP);
        }
        httpServletResponse.sendRedirect("/");
    }
}
