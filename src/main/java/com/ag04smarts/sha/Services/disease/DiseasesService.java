package com.ag04smarts.sha.Services.disease;

import java.util.Map;

/**
 * Interface for a service class that returns the collection
 * of diseases.
 */

public interface DiseasesService {

    /**
     * Returns the map of all diseases.
     *
     * @return map of all diseases
     */

    public Map<String, Long> getCollectionOfDiseases();

}
