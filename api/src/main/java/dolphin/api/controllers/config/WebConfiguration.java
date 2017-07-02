package dolphin.api.controllers.config;

import dolphin.api.controllers.Interpretor.RestfulApiInterpretor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public RestfulApiInterpretor restfulApiInterpretor() {
        return new RestfulApiInterpretor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restfulApiInterpretor())
                .addPathPatterns("/api/**");
    }
}
