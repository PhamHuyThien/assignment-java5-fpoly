package thiendz.j5.assignment.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import thiendz.j5.assignment.filter.FilterAdmin;
import thiendz.j5.assignment.filter.FilterGuest;
import thiendz.j5.assignment.filter.FilterUser;

@Configuration
public class ConfigWebFilter {

//    @Bean
//    public FilterRegistrationBean<AdminFilter> adminFilterConfig() {
//        FilterRegistrationBean<AdminFilter> frb = new FilterRegistrationBean<>();
//        frb.setFilter(new AdminFilter());
//        frb.addUrlPatterns("/admin/*");
//        return frb;
//    }
//
//    @Bean
//    public FilterRegistrationBean<UserFilter> userFilterConfig() {
//        FilterRegistrationBean<UserFilter> frb = new FilterRegistrationBean<>();
//        frb.setFilter(new UserFilter());
//        frb.addUrlPatterns("/list-order", "/payment", "/logout", "/account");
//        return frb;
//    }
//
//    @Bean
//    public FilterRegistrationBean<GuestFilter> guestFilterConfig() {
//        FilterRegistrationBean<GuestFilter> frb = new FilterRegistrationBean<>();
//        frb.setFilter(new GuestFilter());
//        frb.addUrlPatterns("/login", "/register");
//        return frb;
//    }
}
