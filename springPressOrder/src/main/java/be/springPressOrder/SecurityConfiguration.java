package be.springPressOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { auth.userDetailsService(userDetailsService); }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.authorizeRequests()

                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/css/**").permitAll()

                .antMatchers("/", "/h2/**").hasRole("ADMIN")
                .antMatchers("/orders/**").hasAnyRole("ADMIN")
                .antMatchers("/schedule").permitAll()
                .antMatchers(HttpMethod.POST, "/schedule/test").permitAll()
                .antMatchers("/request").hasAnyRole("USER","ADMIN")
                .antMatchers("/request/**").hasAnyRole("USER","ADMIN")
                //.antMatchers("/order/**").hasAnyRole("ADMIN")
                .antMatchers("/pressorders/**").hasAnyRole("USER","ADMIN","TECHNICIAN")
                .antMatchers("/pressorder/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/order/**").hasAnyRole("USER","ADMIN")
                .anyRequest().hasAnyRole("USER","ADMIN").and()
                    .formLogin().loginPage("/login").failureUrl("/login-error")
                        .defaultSuccessUrl("/menu",true).permitAll().and()
                    .logout().invalidateHttpSession(true).logoutSuccessUrl("/logout").permitAll();
        http.exceptionHandling().accessDeniedPage("/403");*/
       http.authorizeRequests().anyRequest().permitAll();
        http.csrf().and().cors().disable();
        http.headers().frameOptions().disable();
    }

  @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN")
                .and()
                .withUser("presser").password(("presser")).roles("USER")
                .and()
                .withUser("technician").password(("technician")).roles("TECHNICIAN");
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
