package com.ag04smarts.sha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Solution to the problem:
 * Using Value, annotate a method that takes a single String argument
 * with a property of your choice, print the argument to console inside
 * the method than note what happens on Spring context initialization
 */

@Configuration
public class GlobalMethodValueAnnotationTest {

    @Value("${clinic.url.twitter}")
    public void testPrinting(String globalLink) {
        System.out.println("Global method value test: " + globalLink);
    }
}
