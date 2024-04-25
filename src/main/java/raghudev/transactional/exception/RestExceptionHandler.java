package raghudev.transactional.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import raghudev.transactional.dtos.ApiResponse;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEmployeeNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        ApiResponse apiResponse = new ApiResponse(resourceNotFoundException.timestamp, resourceNotFoundException.errorMessage, resourceNotFoundException.path);
        return ResponseEntity.status(404).body(apiResponse);

    }

    @ExceptionHandler(value = DataPersistanceException.class)
    public ResponseEntity<ApiResponse> handleDataPersistanceException(DataPersistanceException dataPersistanceException) {
        ApiResponse apiResponse = new ApiResponse(dataPersistanceException.timestamp, dataPersistanceException.errorMessage, dataPersistanceException.path);
        return ResponseEntity.status(500).body(apiResponse);
    }
}
