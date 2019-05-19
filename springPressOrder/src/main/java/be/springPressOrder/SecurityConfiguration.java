package be.springPressOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;


    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/css/**").permitAll()

        .antMatchers("/", "/h2/**").hasRole("ADMIN")
                .antMatchers("/orders/**").hasAnyRole("ADMIN")
                .antMatchers("/weather/**").hasAnyRole("ADMIN")
                //.antMatchers(HttpMethod.POST, "/schedule/test").permitAll()
                .antMatchers("/request").permitAll()
                .antMatchers("/order/**").hasAnyRole("ADMIN")
                .antMatchers("/pressorder/**").hasAnyRole("PRESSER","ADMIN","TECHNICIAN")
                .antMatchers("/technicianOverview/**").hasAnyRole("TECHNICIAN")
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").failureUrl("/login-error")
                .defaultSuccessUrl("/home",true).permitAll().and()
                .logout().invalidateHttpSession(true).logoutSuccessUrl("/logout").permitAll();
        http.exceptionHandling().accessDeniedPage("/403");
        http.csrf().and().cors().disable();
        http.headers().frameOptions().disable();// NEEDED FOR H2 CONSOLE
    }

   /* @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("pv").password("presser").roles("PRESSER")
                .and()
                .withUser("hs").password("admin").roles("ADMIN");
    }*/

}
