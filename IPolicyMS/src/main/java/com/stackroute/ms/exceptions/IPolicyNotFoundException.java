package com.stackroute.ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Policy Not Found....")
public class IPolicyNotFoundException extends Exception {

}
