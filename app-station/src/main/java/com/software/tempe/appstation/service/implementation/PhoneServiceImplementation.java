package com.software.tempe.appstation.service.implementation;

import com.software.tempe.appstation.exception.ResourceNotFoundException;
import com.software.tempe.appstation.model.Phone;
import com.software.tempe.appstation.repository.PhoneRepository;
import com.software.tempe.appstation.service.PhoneService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PhoneServiceImplementation implements PhoneService {

    private final PhoneRepository repository;

    public PhoneServiceImplementation(PhoneRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Phone savePhone(Phone phoneData) {
        return repository.save(phoneData);
    }

    @Override
    public List<Phone> getPhone() {
        return repository.findAll();
    }

    @Override
    public List<Phone> getIDPhone(int id) {
        return Collections.singletonList(repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Phone", "Id", id)));
    }

    @Override
    public Phone updatePhone(Phone phone, int id) {
        // check phone id for update
        Phone current_phone = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Phone", "Id", id)
        );

        // set current to new
        current_phone.setBrand(phone.getBrand());
        current_phone.setDisplay(phone.getDisplay());
        current_phone.setPrice(phone.getPrice());
        current_phone.setRating(phone.getRating());
        current_phone.setDiscount(phone.getDiscount());

        // save to db
        repository.save(current_phone);

        // return new data
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Phone", "Id", id)
        );

    }

    @Override
    public void deletePhone(int id) {
        // check phone id for update
       repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Phone", "Id", id)
        );

        repository.deleteById(id);
    }
}
