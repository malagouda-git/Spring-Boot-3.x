package raghudev.transactional.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguraiton extends WebSecurityConfiguration {

    @Bean
    public UserDetailsService users(){
        UserDetails admin= User.withUsername("admin")
                .password("admin")
                .roles("role")
                .build();
        UserDetails developer = User.withUsername("developer")
                .password("developer")
                .roles("developer")
                .build();
        return new InMemoryUserDetailsManager(admin,developer);
    }


}
