package br.com.ifomeadaf1rst.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8842074565628941613L;

	public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
