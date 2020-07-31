package com.ag04smarts.sha.config.social;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Configuration class that gets the social urls from property file.
 *
 * @author Ivan Jukić
 */

@Configuration
@PropertySource("classpath:sha.properties")
public class SocialWebUrls {

    @Value("${clinic.url.twitter}")
    private String twitterUrl;

    @Value("${clinic.url.linkedin}")
    private String linkedinUrl;

    /**
     * Bean method that creates a String array of social urls.
     *
     * @return String array of social urls
     */

    @Bean
    @Qualifier("socialUrls")
    public String[] getUrls() {
        return new String[]{twitterUrl, linkedinUrl};
    }
}
