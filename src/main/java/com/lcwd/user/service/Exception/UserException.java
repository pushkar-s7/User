package com.lcwd.user.service.Exception;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserException {
	
   @ExceptionHandler(UserNotFoundException.class)
   public ResponseEntity<String> handelUserNotFoundException(UserNotFoundException exception){
	   
	 return new ResponseEntity<>(exception.getMessage(),org.springframework.http.HttpStatus.NOT_FOUND);
	 
   }
   
   @ExceptionHandler(UserCreationException.class)
   public ResponseEntity<String> handleUserCreationException(UserCreationException ex) {
       return new ResponseEntity<>(ex.getMessage(),org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR );
   }
   
 
}
