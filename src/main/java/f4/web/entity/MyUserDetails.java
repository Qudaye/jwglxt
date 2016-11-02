package f4.web.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by xuan on 16-11-1.
 */
public class MyUserDetails extends User implements UserDetails {

    // 权限
    private Collection<GrantedAuthority> authorities;

    public MyUserDetails(User user, Collection<GrantedAuthority> authorities) {
        setId(user.getId());
        setUsername(user.getUsername());
        setPassword(user.getPassword());
        setRoleId(user.getRoleId());
        this.authorities = authorities;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
