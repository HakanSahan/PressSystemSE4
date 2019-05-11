package be.springPressOrder.configuration;

import be.springPressOrder.controllers.MyAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/").permitAll()

                .antMatchers("/fruiteigenaar/**").permitAll()
                .antMatchers("/orders/**").hasAnyRole("ADMIN")
                //.antMatchers("/order/**").hasAnyRole("ADMIN")
                .antMatchers("/fruiteigenaaroverzicht/**").hasAnyRole("ADMIN")
                .antMatchers("/pressorders/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/console/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()

                .formLogin().loginPage("/login").permitAll()

                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);


        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
//antMatchers("/fruiteigenaar").hasAnyRole("ADMIN")
//                .antMatchers("/fruiteigenaarregistratie").hasAnyRole("ADMIN")
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }

}