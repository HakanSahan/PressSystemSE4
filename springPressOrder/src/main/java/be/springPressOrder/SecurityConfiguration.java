package be.springPressOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /*@Autowired
    private AccessDeniedHandler accessDeniedHandler;*/

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
                //.antMatchers("/order/**").hasAnyRole("ADMIN")
                .antMatchers("/pressorders/**").hasAnyRole("USER","ADMIN","TECHNICIAN")
                .antMatchers("/pressorder/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/order/**").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").failureUrl("/login-error")
                .defaultSuccessUrl("/menu",true).permitAll().and()
                .logout().invalidateHttpSession(true).logoutSuccessUrl("/logout").permitAll();
        http.exceptionHandling().accessDeniedPage("/403");
        http.csrf().disable();                                  // NEEDED FOR H2 CONSOLE
        http.headers().frameOptions().disable();                // NEEDED FOR H2 CONSOLE
    }


    /**
     * The default PasswordEncoder is now DelegatingPasswordEncoder which is a non-passive change.
     * This change ensures that passwords are now encoded using BCrypt by default
     */
    /*@Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }*/

    /*@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                //.antMatchers("/").hasAnyRole("USER","ADMIN","TECHNICIAN")
                //.antMatchers("/login*").permitAll()
                .antMatchers("/orders/**","/h2/**").hasRole("ADMIN")
                .antMatchers("/pressorders/**").hasAnyRole("USER","ADMIN","TECHNICIAN")
                .antMatchers("/pressorder/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/order/**").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated().and()

                //.authorizeRequests().antMatchers("/h2/**").hasAnyRole("ADMIN")
                //.and()
                .formLogin().loginPage("/login").permitAll()
                .failureUrl("/login-error")
                .defaultSuccessUrl("/menu",true).permitAll()

                .and()
                .logout()
                .invalidateHttpSession(true).logoutSuccessUrl("/logout").permitAll()

                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();

    }*/

   /* public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }*/


     /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN")
                .and()
                .withUser("presser").password(("presser")).roles("USER")
                .and()
                .withUser("technician").password(("technician")).roles("TECHNICIAN");
    }*/
    /*@Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }*/

}
