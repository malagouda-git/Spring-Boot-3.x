package raghudev.transactional.exception;

import java.time.Instant;

public class DataPersistanceException extends RuntimeException{
    Instant timestamp;
    String errorMessage;
    String path;

    public DataPersistanceException(Instant timestamp, String errorMessage, String path) {
        this.timestamp = timestamp;
        this.errorMessage = errorMessage;
        this.path = path;
    }
}
