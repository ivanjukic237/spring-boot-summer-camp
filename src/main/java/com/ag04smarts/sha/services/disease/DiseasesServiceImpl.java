package com.ag04smarts.sha.services.disease;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Service that returns the collection of all diseases.
 *
 * @author Ivan Jukić
 */

@Component
public class DiseasesServiceImpl implements DiseasesService {

    private final Map<String, Long> collectionOfDiseases;

    /**
     * Constructor for the class. @Qualifier tag determines which kind
     * of map will be injected.
     *
     * @param collectionOfDiseases map of all diseases
     */

    public DiseasesServiceImpl(Map<String, Long> collectionOfDiseases) {
        this.collectionOfDiseases = collectionOfDiseases;
    }

    /**
     * {@inheritDoc}
     */

    public Map<String, Long> getCollectionOfDiseases() {
        return collectionOfDiseases;
    }
}
