package com.intuit.jobsearch.userinfo.controller;

import com.intuit.jobsearch.common.model.UserInfo;
import com.intuit.jobsearch.common.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;

    Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @RequestMapping(value="getAllUserInfo", method= RequestMethod.GET)
    public ResponseEntity<List<UserInfo>> getAllUserInfo()
    {
        return new ResponseEntity<List<UserInfo>>(userInfoService.getAllUserInfo(), HttpStatus.OK);
    }

    @RequestMapping(value="createNewUser", method= RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> createNewUser(@Valid @RequestBody UserInfo userInfo)  throws Exception
    {
        if(userInfo!=null)
        {
            logger.info("userInfo userType="+userInfo.getUserType());
            logger.info("userInfo FirstName="+userInfo.getFirstName());
        }
        else
        {
            logger.error("userInfo is null");
        }
        userInfoService.createNewUser(userInfo);
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
