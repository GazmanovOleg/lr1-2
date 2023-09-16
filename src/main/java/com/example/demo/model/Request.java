package com.example.demo.model;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Request {
   
    @NotNull
    @Size(max = 32)
    private String uid;

    @NotNull
    @Size(max = 32)
    private String operationUid;

    private String systemName;

    @NotNull
    private String systemTime;
    private String source;

    private Integer communicationId;
    private Integer template;

    @Max(7)
    private Integer productCode;

    @Max(5)
    private Integer  smsCode;


    
}
