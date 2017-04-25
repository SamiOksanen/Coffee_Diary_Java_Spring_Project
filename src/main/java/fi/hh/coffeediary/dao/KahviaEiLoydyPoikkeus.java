package fi.hh.coffeediary.dao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class KahviaEiLoydyPoikkeus extends RuntimeException {

	public KahviaEiLoydyPoikkeus(Exception cause) {
		super(cause);
	}
	
}
