package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.IMPLImaExp;
import com.bosch.example.impl.IMPLReverse;
import com.bosch.example.services.ImaExpService;
import com.bosch.example.services.ReverseService;

@Configuration
public class DependenciesConfiguration {
    
    @Bean
    @Scope("singleton")
    public ReverseService reverseService() {
        return new IMPLReverse();
    }

    @Bean
    @Scope("singleton")
    public ImaExpService iamexpService() {
        return new IMPLImaExp();
    }
}
