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
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/").hasAnyRole("PRESSER","ADMIN","TECHNICIAN")
                .antMatchers("/menu/**").hasAnyRole("PRESSER","ADMIN","TECHNICIAN")

                .antMatchers("/fruiteigenaar/**").permitAll()
                .antMatchers("/orderrest/**").permitAll()
                .antMatchers("/orders/**").hasAnyRole("ADMIN")
                //.antMatchers("/order/**").hasAnyRole("ADMIN")
                .antMatchers("/fruiteigenaaroverzicht/**").hasAnyRole("ADMIN")
                .antMatchers("/pressorders/**").hasAnyRole("PRESSER","ADMIN")
                .antMatchers("/weather/**").hasAnyRole("ADMIN")
                .antMatchers("/technicianOverview/**").hasAnyRole("TECHNICIAN")
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
    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("pv").password("{bcrypt}$2a$10$QfNyqLAr24uJVmFMiFC7luVH98wIDefLEL9Z.MRNuKDe9n3YGOMR.").roles("PRESSER")
                .and()
                .withUser("hs").password("{bcrypt}$2a$10$tQADq.D9jOmYE0BGKgfWgOUrC0Pi5kJr/DiPLfJkh0tecqzBaTB82").roles("ADMIN");

    }*/


}