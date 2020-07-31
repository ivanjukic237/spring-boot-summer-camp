package com.ag04smarts.sha.info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * Configuration class that finds the active profiles.
 */

@Configuration
public class PropertyInformation {

    @Resource
    public Environment env;

    /**
     * Bean that returns the active profiles property.
     *
     * @return active profiles property
     */

    @Bean
    public String getNumberOfPatientsProperty() {
        String property = env.getProperty("spring.profiles.active");
        String profile = null;

        if (property != null) {
            String[] profiles = property.split(",");
            for (String profileArgument : profiles) {
                if (profileArgument.contains("numberOf")) {
                    profile = profileArgument.replace("numberOf_", "").strip();
                    break;
                }
            }
        }
        return (profile == null ? "" : profile);
    }
}
