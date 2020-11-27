package com.stackroute.ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="Customer Already Exists.....")
public class CustomerAlreadyExistsException extends Exception {

}
