package com.poc.contract.integration;

import com.poc.contract.integration.exception.BadRequestException;
import com.poc.contract.integration.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
 
        switch (response.status()){
            case 400:
                return new BadRequestException("Bad Request");
            case 404:
                return new NotFoundException("Not Found Exception");
            default:
                return new Exception("Generic error");
        }
    }
}
