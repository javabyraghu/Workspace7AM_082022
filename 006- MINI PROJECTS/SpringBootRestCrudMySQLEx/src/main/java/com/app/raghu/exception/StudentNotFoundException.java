package com.app.raghu.exception;

public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException() {
		super();
	}
	public StudentNotFoundException(String message) {
		super(message);
	}
}
