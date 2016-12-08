package cavalli.config;

import org.springframework.context.annotation.*;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by Ola on 04.11.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"cavalli"})
@Import({HibernateConfig.class
        ,ThymeleafConfig.class
        ,SecurityConfig.class})
@PropertySource(value = {"classpath:application.properties"})
@EnableJpaRepositories("cavalli.repository")
public class AppConfig extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = new String[]{
            "classpath:/resources/",
            "classpath:/static/",
            "classpath:/templates/",
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

//
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
//        configurer.enable();
//    }
}
