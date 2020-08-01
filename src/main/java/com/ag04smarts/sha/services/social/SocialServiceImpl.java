package com.ag04smarts.sha.services.social;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Implementation of the service that returns the social urls
 * from the clinic.
 *
 * @author Ivan Jukić
 */

@Service
public class SocialServiceImpl implements SocialService {

    String[] urls;

    /**
     * Constructor for the class.
     *
     * @param urls array of social urls
     */

    public SocialServiceImpl(@Qualifier("socialUrls") String[] urls) {
        this.urls = urls;
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public String[] getUrls() {
        return urls;
    }

}
