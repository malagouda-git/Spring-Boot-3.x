package raghudev.transactional.exception;

import java.time.Instant;

public class ResourceNotFoundException extends  RuntimeException{

    Instant timestamp;
    String errorMessage;
    String path;

    public ResourceNotFoundException(Instant timestamp,String errorMessage, String path){
        super(errorMessage);
        this.timestamp=timestamp;
        this.errorMessage=errorMessage;
        this.path=path;
    }


}
