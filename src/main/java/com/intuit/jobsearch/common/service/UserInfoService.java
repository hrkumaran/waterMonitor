package com.intuit.jobsearch.common.service;

import com.intuit.jobsearch.common.model.UserInfo;
import com.intuit.jobsearch.common.repository.UserInfoRepository;
import com.intuit.jobsearch.waterMonitor.model.WaterReadingDetails;
import com.intuit.jobsearch.waterMonitor.repository.WaterReadingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private WaterReadingRepository waterReadingRepository;
   
    public void createNewUser(UserInfo userInfo) {
        logger.info(userInfo.getAddress());
        WaterReadingDetails waterReadingDetails = createWaterReadingDetails(userInfo);
        waterReadingRepository.save(waterReadingDetails);
        userInfoRepository.save(userInfo);
    }

    private WaterReadingDetails createWaterReadingDetails(UserInfo userInfo) {
        WaterReadingDetails waterReadingDetails = new WaterReadingDetails();
        waterReadingDetails.setWaterConsumptionLitre(0l);
        waterReadingDetails.setPreviousMeterReading(0l);
        waterReadingDetails.setCurrentMeterReading(0l);
        waterReadingDetails.setAmount(0.00f);
        waterReadingDetails.setUserId(userInfo.getUserId());
        waterReadingDetails.setRrNo(userInfo.getRrNo());
        return waterReadingDetails;
    }

    public List<UserInfo> getAllUserInfo() {
        return userInfoRepository.findAll();
    }

    public UserInfo getUserInfobyId(Long userId) {
        logger.info("userId="+userId);
        return userInfoRepository.getById(userId);
    }
}
