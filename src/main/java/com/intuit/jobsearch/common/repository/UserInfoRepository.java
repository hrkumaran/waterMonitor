package com.intuit.jobsearch.common.repository;

import com.intuit.jobsearch.common.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

}
