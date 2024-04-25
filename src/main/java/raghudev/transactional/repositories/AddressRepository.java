package raghudev.transactional.repositories;

import org.springframework.data.repository.CrudRepository;
import raghudev.transactional.entities.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Long>{
    AddressEntity findByAddressId(Long addressId);
}
