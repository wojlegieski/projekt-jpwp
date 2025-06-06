package MyException;

public class InvalidFormatException extends RuntimeException {
  private final int lineNumber;
  private final String lineContent;



  public InvalidFormatException(String line, int lineNumber, Throwable cause) {
    super("Błędny format w linii " + lineNumber + ": \"" + line + "\"", cause);
    this.lineNumber = lineNumber;
    this.lineContent = line;
  }

  public InvalidFormatException(String line, int lineNumber) {
    this(line, lineNumber, null);
  }
  public int getLineNumber() {
    return lineNumber;
  }
  public String getLineContent() {
    return lineContent;
  }}
