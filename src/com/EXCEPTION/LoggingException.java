package com.EXCEPTION;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingException extends Exception {
	private static final long serialVersionUID = 1L;

	public static Logger logger = Logger.getLogger("Logging Exception"); 
	
	public LoggingException() { 
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}
