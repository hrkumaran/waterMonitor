package com.intuit.jobsearch.waterMonitor.repository;

import com.intuit.jobsearch.waterMonitor.controller.WaterReadingController;
import com.intuit.jobsearch.waterMonitor.model.WaterReadingDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterReadingRepository extends JpaRepository<WaterReadingDetails,Long> {

}
