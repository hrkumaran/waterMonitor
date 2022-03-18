package com.intuit.jobsearch.common.service;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserTypeWaterAmountFactory  {
    public UserTypeWaterAmount getUserTypeWaterAmount(String userType)
    {
        if (userType == null || userType.isEmpty())
            return null;
        switch (userType) {
            case "Individual":
                return new IndividualWaterAmount();
            case "Commerical":
                return new CommericalWaterAmount();
            case "Official":
                return new OfficialWaterAmount();
            default:
                throw new IllegalArgumentException("Unknown channel "+userType);
        }
    }
}
