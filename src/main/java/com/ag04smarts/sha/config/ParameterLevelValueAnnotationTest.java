package com.ag04smarts.sha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Class to solve a problem from week 2 homework:
 *
 * Problem:
 * Use the Value annotation on a method at parameter level to autowire arguments with property values
 */

@Configuration
public class ParameterLevelValueAnnotationTest {

    /**
     * Method autowires property in the method
     *
     * @param twitterSocial twitter social link
     */

    public String testParameterLevelAutowire(@Value("${clinic.url.twitter}") String twitterSocial) {
        return "Autowired from parameter: " + twitterSocial;
    }
}
