package pl.camp.it.delivery.system.configuration;

import org.hibernate.SessionFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.camp.it.delivery.system.filters.LoggedUserFilter;
import pl.camp.it.delivery.system.filters.StorekeeperFilter;
import pl.camp.it.delivery.system.filters.SupervisorFilter;

@Configuration
@ComponentScan("pl.camp.it.delivery.system")
public class AppConfiguration {
    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean
    public FilterRegistrationBean<SupervisorFilter> supervisorFilter() {
        FilterRegistrationBean<SupervisorFilter> supervisorFilter = new FilterRegistrationBean<>();

        supervisorFilter.setFilter(new SupervisorFilter());
        supervisorFilter.addUrlPatterns("/supervisor/*");

        return supervisorFilter;
    }

    @Bean
    public FilterRegistrationBean<LoggedUserFilter> loggedUserFilter() {
        FilterRegistrationBean<LoggedUserFilter> loggedUserFilter = new FilterRegistrationBean<>();

        loggedUserFilter.setFilter(new LoggedUserFilter());
        loggedUserFilter.addUrlPatterns("/changePass");

        return loggedUserFilter;
    }

    @Bean
    public FilterRegistrationBean<StorekeeperFilter> storekeeperFilter() {
        FilterRegistrationBean<StorekeeperFilter> storekeeperFilter = new FilterRegistrationBean<>();

        storekeeperFilter.setFilter(new StorekeeperFilter());
        storekeeperFilter.addUrlPatterns("/storekeeper/*");

        return storekeeperFilter;
    }
}
