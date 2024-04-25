package raghudev.transactional.mappers;

import raghudev.transactional.dtos.AddressDTO;
import raghudev.transactional.entities.AddressEntity;

public class AddressMapper {

    public static AddressDTO getAddressDTO(AddressEntity addressEntity){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(addressEntity.getAddressId());
        addressDTO.setCity(addressEntity.getCity());
        addressDTO.setStreet(addressEntity.getStreet());
        addressDTO.setState(addressEntity.getState());
        addressDTO.setCountry(addressEntity.getCountry());
        return addressDTO;
    }

    public static AddressEntity getAddressEntity(AddressDTO addressDTO){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(addressDTO.getAddressId());
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setStreet(addressDTO.getStreet());
        addressEntity.setState(addressDTO.getState());
        addressEntity.setCountry(addressDTO.getCountry());
        return addressEntity;
    }
}
