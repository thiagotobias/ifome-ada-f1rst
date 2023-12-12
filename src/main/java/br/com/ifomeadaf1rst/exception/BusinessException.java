package br.com.ifomeadaf1rst.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -6850084565676231406L;
	
	public BusinessException(String message) {
        super(message);
    }
		
}
