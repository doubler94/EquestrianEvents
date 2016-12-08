package cavalli.config;


import javax.sql.DataSource;

import cavalli.authorizer.AuthenticationService;
import cavalli.authorizer.LoginSuccessHandlerRedirect;
import cavalli.authorizer.LogoutSuccessHandlerRedirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * Created by Ola on 18.11.2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    LoginSuccessHandlerRedirect loginSuccessHandlerRedirect;

    @Autowired
    LogoutSuccessHandlerRedirect logoutSuccessHandlerRedirect;

    @Autowired
    DataSource dataSource;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/", "/index").permitAll()
                    .antMatchers("/resources/**").permitAll()
                    .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/organizer/**").access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/rider/**").access("hasRole('ROLE_USER')")
                    .antMatchers("/db/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_DBA')")
                    .and()
                .formLogin()
                    .loginPage("/login").successHandler(loginSuccessHandlerRedirect)
                    .usernameParameter("login").passwordParameter("password")
                    .and()
                .csrf()
                    .and()
                .logout()
                    .logoutUrl("/logout")
//                    .logoutSuccessHandler(logoutSuccessHandlerRedirect)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .and()
                .exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}
