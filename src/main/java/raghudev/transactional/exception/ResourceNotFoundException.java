package raghudev.transactional.exception;

public class ResourceNotFoundException extends  RuntimeException{

    Long timestamp;
    String errorMessage;
    String path;

    public ResourceNotFoundException(Long timestamp,String errorMessage, String path){
        this.timestamp=timestamp;
        this.errorMessage=errorMessage;
        this.path=path;
    }


}
