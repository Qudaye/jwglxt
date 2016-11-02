package f4.web.security;

import f4.web.dao.RoleDao;
import f4.web.dao.UserDao;
import f4.web.entity.MyUserDetails;
import f4.web.entity.Role;
import f4.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by xuan on 16-11-1.
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try {
            user = userDao.getByUsername(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user select fail.");
        }
        if (user == null) {
            throw new UsernameNotFoundException("no user found.");
        }
        Role role;
        try {
            role = roleDao.selectByPrimaryKey(user.getRoleId());
        } catch (Exception e) {
            throw new UsernameNotFoundException("user role select fail.");
        }
        if (role == null) {
            throw new UsernameNotFoundException("user have no role.");
        }
        return new MyUserDetails(user, getAuthorities(role));
    }

    private Collection<GrantedAuthority> getAuthorities(Role role) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getName());
        grantedAuthorities.add(grantedAuthority);
        return grantedAuthorities;
    }
}
