package tourGuide.configuration;

import gpsUtil.GpsUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public GpsUtil gpsUtil() {
        return new GpsUtil();
    }
}
