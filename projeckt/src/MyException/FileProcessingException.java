package MyException;

public class FileProcessingException extends RuntimeException {
  public FileProcessingException(String filePath, String msg, Throwable cause) {
    super("Błąd pliku [" + filePath + "]: " + msg, cause);
  }}
