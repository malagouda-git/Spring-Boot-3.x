package raghudev.transactional.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    Long timeStamp;
    String errorMessage;
    String path;
}
