package demo.sbhdhr.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException {

	private static final long serialVersionUID = -3432970254510414077L;

	public ProjectIdException(String message) {
		super(message);

	}

}
