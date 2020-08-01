package com.ag04smarts.sha.controllers.disease;

import com.ag04smarts.sha.services.disease.DiseasesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller that maps the diseases page that gives the map of all
 * diseases and the number of people having that disease. Type of map
 * is determined by the
 * {@link com.ag04smarts.sha.services.disease.DiseasesServiceImpl}
 * configuration. Type of maps that can be shown is defined in
 * {@link com.ag04smarts.sha.config.DiseasesConfiguration}.
 *
 * @author Ivan Jukić
 */

@RestController
public class DiseasesController {

    private final DiseasesService diseasesService;

    /**
     * Constructor for the class.
     *
     * @param diseasesService diseasesService that prepares the map of all patients
     */

    public DiseasesController(DiseasesService diseasesService) {
        this.diseasesService = diseasesService;
    }

    /**
     * Mapping for the map of all diseases.
     *
     * @return map of all diseases
     */

    @GetMapping("/api/patient/diseases")
    public Map<String, Long> printAllDiseases() {
        return diseasesService.getCollectionOfDiseases();
    }
}
