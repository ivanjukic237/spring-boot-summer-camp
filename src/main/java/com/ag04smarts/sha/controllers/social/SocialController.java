package com.ag04smarts.sha.controllers.social;

import com.ag04smarts.sha.Services.social.SocialService;
import com.ag04smarts.sha.config.social.SocialWebUrls;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller clas that maps the social links given by the
 * {@link SocialWebUrls}.
 *
 * @author Ivan Jukić
 */

@RestController
public class SocialController {

    private final SocialService socialService;

    /**
     * Constructor for the class.
     *
     * @param socialService service that gives the array of social urls.
     */

    public SocialController(SocialService socialService) {
        this.socialService = socialService;
    }

    /**
     * Maps the array of social links.
     *
     * @return array of social links
     */

    @GetMapping("/api/social")
    public String[] socialMapping() {
        return socialService.getUrls();
    }
}
