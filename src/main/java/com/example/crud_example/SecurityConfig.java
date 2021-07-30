package com.example.crud_example;


import com.example.crud_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    /*
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    */
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());

    }
    */


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/").hasAnyRole("ADMIN")
                .antMatchers("/updateProject/**").hasAnyRole("ADMIN")
                .antMatchers("/showNewProject/**").hasAnyRole("ADMIN")
                .antMatchers("/deleteProject/**").hasAnyRole("ADMIN")
                .antMatchers("/updatePartner/**").hasAnyRole("ADMIN")
                .antMatchers("/showNewPartner/**").hasAnyRole("ADMIN")
                .antMatchers("/deletePartner/**").hasAnyRole("ADMIN")
                .antMatchers("/updateCountry/**").hasAnyRole("ADMIN")
                .antMatchers("/showNewCountry/**").hasAnyRole("ADMIN")
                .antMatchers("/deleteCountry/**").hasAnyRole("ADMIN")
                .antMatchers("/saveUserAdmin/**").hasAnyRole("ADMIN")
                .antMatchers("/updateUser/**").hasAnyRole("ADMIN")
                .antMatchers("/deleteUser/**").hasAnyRole("ADMIN")
                .antMatchers("/users").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/createUser").permitAll()
                .antMatchers("/").permitAll()
                .and().formLogin().
                loginPage("/login")
                .defaultSuccessUrl("/home", true);

        http.csrf().disable(); // kullanıcı eklerken hata veriyordu
        http
                .logout(logout -> logout
                        .logoutUrl("/home/logout")
                        .addLogoutHandler(new SecurityContextLogoutHandler())
                        .logoutSuccessUrl("/")
                );

    }

}
