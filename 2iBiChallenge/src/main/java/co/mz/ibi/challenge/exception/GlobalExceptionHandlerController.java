package co.mz.ibi.challenge.exception;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) throws IOException{
		
		 Map<String,String> erros = new HashMap<>();
		 ex.getBindingResult().getAllErrors().forEach((error)->{
			 String fieldName = ((FieldError) error).getField();
			 String errorMessage = error.getDefaultMessage();
			 erros.put(fieldName, errorMessage);
		 });
		 return new ResponseEntity<>(erros, HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public void handle(HttpServletResponse res) throws IOException{
			res.sendError(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.getReasonPhrase());
	}

	
	@ExceptionHandler(Exception.class)
	public void handleException(HttpServletResponse res) throws IOException {
	    res.sendError(HttpStatus.BAD_REQUEST.value(), "Erro :" + res);
	}

}
