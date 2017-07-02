package dolphinweb.config;

import dolphinweb.Interpretor.RestfulApiInterpretor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public RestfulApiInterpretor restfulApiInterceptor() {
        return new RestfulApiInterpretor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(restfulApiInterceptor())
                .addPathPatterns("/api/**");
    }
}
