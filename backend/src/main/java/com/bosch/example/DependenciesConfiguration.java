package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DefaultMailValidator;
import com.bosch.example.impl.DefaultPasswordValidator;
import com.bosch.example.impl.DefaultUserAuth;
import com.bosch.example.impl.IMPLImaExp;
import com.bosch.example.impl.IMPLReverse;
import com.bosch.example.services.ImaExpService;
import com.bosch.example.services.MailValidator;
import com.bosch.example.services.PasswordValidator;
import com.bosch.example.services.ReverseService;
import com.bosch.example.services.UserAuth;

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

    @Bean
    @Scope("singleton")
    public UserAuth userAuth() {
        return new DefaultUserAuth();
    }

    @Bean
    @Scope("singleton")
    public PasswordValidator passwordValidator() {
        return new DefaultPasswordValidator();
    }

    @Bean
    @Scope("singleton")
    public MailValidator mailValidator() {
        return new DefaultMailValidator();
    }
}
