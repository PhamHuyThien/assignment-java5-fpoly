package thiendz.j5.assignment.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thiendz.j5.assignment.filter.AdminFilter;
import thiendz.j5.assignment.filter.GuestFilter;
import thiendz.j5.assignment.filter.UserFilter;

@Configuration
public class ApplicationConfig {

    @Bean
    public FilterRegistrationBean<AdminFilter> adminFilterConfig() {
        FilterRegistrationBean<AdminFilter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new AdminFilter());
        frb.addUrlPatterns("/admin/*");
        return frb;
    }

    @Bean
    public FilterRegistrationBean<UserFilter> userFilterConfig() {
        FilterRegistrationBean<UserFilter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new UserFilter());
        frb.addUrlPatterns("/list-order", "/payment", "/logout");
        return frb;
    }

    @Bean
    public FilterRegistrationBean<GuestFilter> guestFilterConfig() {
        FilterRegistrationBean<GuestFilter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new GuestFilter());
        frb.addUrlPatterns("/login", "/register");
        return frb;
    }
}
