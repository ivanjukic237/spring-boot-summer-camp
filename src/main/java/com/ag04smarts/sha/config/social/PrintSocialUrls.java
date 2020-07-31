package com.ag04smarts.sha.config.social;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Prints the two social urls during the initialization.
 * Link Strings are taken from property files.
 *
 * @author Ivan Jukić
 */

@Configuration
public class PrintSocialUrls {

    /**
     * Gets the value from property files and prints them to console.
     *
     * @param twitterUrl  twitter link of the clinic
     * @param linkedinUrl linkedin link of the clinic
     */

    public PrintSocialUrls(@Value("${clinic.url.twitter}") String twitterUrl, @Value("${clinic.url.linkedin}") String linkedinUrl) {
        System.out.println("Twitter link: " + twitterUrl);
        System.out.println("Linkedin link: " + linkedinUrl);
    }
}
