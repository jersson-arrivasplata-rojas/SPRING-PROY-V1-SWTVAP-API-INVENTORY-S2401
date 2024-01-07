package com.jersson.arrivasplata.swtvap.api.inventory.config;

import com.jersson.arrivasplata.swtvap.api.inventory.util.UtilityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UtilityService utilityService() {
        return new UtilityService();
    }
}
