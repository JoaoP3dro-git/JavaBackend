package com.bosch.example.impl;

import com.bosch.example.dto.ImaExpResult;
import com.bosch.example.services.ImaExpService;

public class IMPLImaExp implements ImaExpService{
    @Override
    public ImaExpResult calculate(Long A, Long b) {
        Double Re = A * Math.sin(b);
        Double Im = A * Math.cos(b);
        return new ImaExpResult(Re, Im);
    }
}
