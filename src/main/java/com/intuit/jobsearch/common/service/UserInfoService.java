package com.intuit.jobsearch.common.service;

import com.intuit.jobsearch.common.model.UserInfo;
import com.intuit.jobsearch.common.repository.UserInfoRepository;
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
   
    public void createNewUser(UserInfo userInfo) {
        logger.info(userInfo.getAddress());
        userInfoRepository.save(userInfo);
    }

    public List<UserInfo> getAllUserInfo() {
        return userInfoRepository.findAll();
    }

    public UserInfo getUserInfobyId(Long userId) {
        logger.info("userId="+userId);
        return userInfoRepository.getById(userId);
    }
}
