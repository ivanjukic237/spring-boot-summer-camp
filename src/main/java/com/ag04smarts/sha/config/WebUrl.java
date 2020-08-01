package com.ag04smarts.sha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class that takes the value from the properties
 * file and prints it to the console.
 *
 * @author Ivan Jukić
 */

import javax.annotation.PostConstruct;

@Configuration
@ConfigurationProperties("resources")
public class WebUrl {

    @Value("${clinic.web.url}")
    private String webUrl;

    /**
     * Method that is executed after dependency injection is done
     * and it prints the collected webUrl property.
     */

    @PostConstruct
    public void printWebUrl() {
        System.out.println(webUrl);
    }
}
