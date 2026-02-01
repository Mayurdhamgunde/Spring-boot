package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    
    @Override
    public String getDailyworkout(){
        return "Do tennis practice daily at tennis court";
    }
}
