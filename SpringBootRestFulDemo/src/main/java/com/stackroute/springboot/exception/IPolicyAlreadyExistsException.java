package com.stackroute.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="Policy Already Exists.....")
public class IPolicyAlreadyExistsException extends Exception 
{

}
