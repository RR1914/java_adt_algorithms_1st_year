package lists;

public class LinkedListException extends Throwable {

  private final String e;

  public LinkedListException(String e) {
    super();
    this.e = e;
  }

  public String toString() {
    return e;
  }

}
