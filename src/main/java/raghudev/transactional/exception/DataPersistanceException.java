package raghudev.transactional.exception;

public class DataPersistanceException extends RuntimeException{
    Long timestamp;
    String errorMessage;
    String path;

    public DataPersistanceException(Long timestamp, String errorMessage, String path) {
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
        this.path = path;
    }
}
