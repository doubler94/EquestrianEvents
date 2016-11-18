package cavali.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by Ola on 04.11.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"cavali"})
@Import({HibernateConfig.class
        ,ThymeleafConfig.class
        ,SecurityConfiguration.class})
@PropertySource(value = {"classpath:application.properties"})
@EnableJpaRepositories("cavali.repository")
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
