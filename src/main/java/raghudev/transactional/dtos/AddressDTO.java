package raghudev.transactional.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDTO {

    private Long addressId;
    private String street;
    private String city;
    private String state;
    private String country;
}
