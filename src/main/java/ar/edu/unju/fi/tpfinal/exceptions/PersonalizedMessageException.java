package ar.edu.unju.fi.tpfinal.exceptions;

public class PersonalizedMessageException extends RuntimeException { 
    private static final long serialVersionUID = 0;
    private Throwable cause;
    
	public PersonalizedMessageException(String message) {
		super(message);
	
	}

    
	 /**
     * Constructs a new Exception with the specified cause.
     * @param cause The cause.
     */
    public PersonalizedMessageException(Throwable cause) {
        super(cause.getMessage());
        this.cause = cause;
    }

    /**
     * Returns the cause of this exception or null if the cause is nonexistent
     * or unknown.
     *
     * @return the cause of this exception or null if the cause is nonexistent
     *          or unknown.
     */
    @Override
    public Throwable getCause() {
        return this.cause;
    }
    
}