package caps.chat.service.capstonproject2.Login.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Students {
    @Id
    private String stuId;

    private String stuPwd;

    private String StuName;

    @Setter
    private String StuImg;

    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorise(){
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(role));

        return roles;
    }
}