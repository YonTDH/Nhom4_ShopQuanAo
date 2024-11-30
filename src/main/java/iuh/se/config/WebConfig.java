package iuh.se.config;

import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // Dùng DateFormatter với định dạng 'dd/MM/yyyy'
        registry.addFormatterForFieldType(LocalDate.class, new DateFormatter("dd/MM/yyyy"));
    }
}
