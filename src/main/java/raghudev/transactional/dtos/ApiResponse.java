package raghudev.transactional.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    Instant timeStamp;
    String errorMessage;
    String path;
}
