package be.springPressOrder;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean dbBean = new ServletRegistrationBean(new WebServlet());
        dbBean.addUrlMappings("/console/*");
        return dbBean;
    }

    @Bean
    ServletRegistrationBean loginRegistration() {
        ServletRegistrationBean loginBean = new ServletRegistrationBean(new WebServlet());
        loginBean.addUrlMappings("/login/*");
        return loginBean;
    }
}
