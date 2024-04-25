package raghudev.transactional.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "address_table", schema = "public")
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long addressId;
    private String street;
    private String city;
    private String state;
    private String country;
}
