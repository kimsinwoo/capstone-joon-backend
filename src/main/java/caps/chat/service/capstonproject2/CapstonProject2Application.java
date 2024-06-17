package caps.chat.service.capstonproject2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CapstonProject2Application {

    public static void main(String[] args) {
        SpringApplication.run(CapstonProject2Application.class, args);
    }

}
