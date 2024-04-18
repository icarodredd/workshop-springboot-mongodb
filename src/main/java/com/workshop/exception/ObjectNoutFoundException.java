package com.workshop.exception;

public class ObjectNoutFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNoutFoundException (String msg) {
		super(msg);
	}

}
