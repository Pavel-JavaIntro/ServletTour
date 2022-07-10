package by.course.tourist.aspect;

import by.course.tourist.exception.IncorrectData;
import by.course.tourist.exception.NoSuchIDException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IdExceptionHandler {
  @ExceptionHandler
  public ResponseEntity<IncorrectData> handleEx(NoSuchIDException ex) {
    IncorrectData id = new IncorrectData();
    id.setInfo(ex.getMessage());
    return new ResponseEntity<IncorrectData>(id, HttpStatus.NOT_FOUND);
  }
}
