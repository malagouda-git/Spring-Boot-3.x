package raghudev.transactional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import raghudev.transactional.dtos.AddressDTO;
import raghudev.transactional.entities.AddressEntity;
import raghudev.transactional.exception.DataPersistanceException;
import raghudev.transactional.exception.ResourceNotFoundException;
import raghudev.transactional.mappers.AddressMapper;
import raghudev.transactional.repositories.AddressRepository;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public AddressDTO getAddress(@PathVariable Long id){
        AddressEntity addressEntity = addressRepository.findByAddressId(id);
        if(addressEntity == null){
            throw new ResourceNotFoundException(System.currentTimeMillis(),"Address not found","/getEmployee/");
        }
        return AddressMapper.getAddressDTO(addressEntity);
    }

    public AddressDTO saveAddress(AddressDTO addressDTO){
        AddressEntity addressEntity = addressRepository.save(AddressMapper.getAddressEntity(addressDTO));
        if(addressEntity == null)
            throw new DataPersistanceException(System.currentTimeMillis(),"Address not saved","/getEmployee/");
        return AddressMapper.getAddressDTO(addressEntity);
    }
}
