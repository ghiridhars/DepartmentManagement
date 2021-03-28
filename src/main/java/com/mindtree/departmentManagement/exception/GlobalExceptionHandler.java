package com.mindtree.departmentManagement.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler(InvalidDepartmentException.class)
//	public ResponseEntity<?> handleInvalidDepartmentException(InvalidDepartmentException e, WebRequest wr) {
//		ErrorDetails ed = new ErrorDetails(new Date(), e.getMessage(), wr.getDescription(false));
//		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
//	}
//	
//	@ExceptionHandler(DepartmentServiceException.class)
//	public ResponseEntity<?> handleDepartmentServiceException(DepartmentServiceException e, WebRequest wr) {
//		ErrorDetails ed = new ErrorDetails(new Date(), e.getMessage(), wr.getDescription(false));
//		return new ResponseEntity<ErrorDetails>(ed,HttpStatus.BAD_REQUEST);
//	}
//	
	@ExceptionHandler(DepartmentManageException.class)
	public ResponseEntity<?> handleDepartmentManageException(DepartmentManageException e, WebRequest wr) {
		ErrorDetails ed = new ErrorDetails(new Date(), e.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
	}
//	
//	@ExceptionHandler(InvalidEmployeeException.class)
//	public ResponseEntity<?> handleInvalidStudentException(InvalidEmployeeException e, WebRequest wr) {
//		ErrorDetails ed = new ErrorDetails(new Date(), e.getMessage(), wr.getDescription(false));
//		return new ResponseEntity<>(ed,HttpStatus.BAD_REQUEST);
//	}
}
