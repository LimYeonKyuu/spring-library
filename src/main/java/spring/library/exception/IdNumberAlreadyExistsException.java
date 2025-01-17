package spring.library.exception;

public class IdNumberAlreadyExistsException extends RuntimeException {

  private static final String MESSAGE = "이미 존재하는 아이디입니다.";

  public IdNumberAlreadyExistsException() {
    super(MESSAGE);
  }
}
