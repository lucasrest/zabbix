package exception;

public class ZabbixException extends RuntimeException {

    public ZabbixException() {
    }

    public ZabbixException(String message) {
        super(message);
    }
}
