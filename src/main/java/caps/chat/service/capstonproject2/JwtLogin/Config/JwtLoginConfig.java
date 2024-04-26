package caps.chat.service.capstonproject2.JwtLogin.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class JwtLoginConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity https) throws Exception{
        https
                .authorizeHttpRequests((authorize) -> authorize.requestMatchers("/**").permitAll());
        return https.build();
    }
}
