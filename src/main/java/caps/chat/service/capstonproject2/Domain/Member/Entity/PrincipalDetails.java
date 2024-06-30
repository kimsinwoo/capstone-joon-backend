package caps.chat.service.capstonproject2.Domain.Member.Entity;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@RequiredArgsConstructor
public class PrincipalDetails implements UserDetails {
    private Student student;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null;
    }

    public Student getStudent(){
        return student;
    }

    @Override
    public String getPassword() {
        return student.getStuPwd();
    }

    @Override
    public String getUsername() {
        return student.getStuName();
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
