package com.intuit.jobsearch.waterMonitor.repository;

import com.intuit.jobsearch.waterMonitor.model.WaterReadingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterReadingRepository extends JpaRepository<WaterReadingDetails,Long> {

}
