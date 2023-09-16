package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Request;
import com.example.demo.model.Response;
import com.example.demo.service.MyModifyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MyController {
    private final MyModifyService myModifyService;
    
    @Autowired
    public MyController(@Qualifier("ModifyErrorMessage") MyModifyService myModifyService){
        this.myModifyService = myModifyService;
    }

    @PostMapping(value="/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request) {
        log.info("Входящий request : " + String.valueOf(request));
        
        Response response = Response.builder()
                 .uid(request.getUid())
                 .operationUid(request.getOperationUid())
                 .systemTime(request.getSystemTime())
                 .code("succes")
                 .errorCode("")
                 .errorMessage("")
                 .build();
        Response responseAfterModify = myModifyService.modify(response);
        log.info(" Исходящий response : " + String.valueOf(response));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
