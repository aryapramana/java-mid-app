package com.software.tempe.appstation.service;

import com.software.tempe.appstation.model.Phone;

import java.util.List;

public interface PhoneService {

    // post data to db
    Phone savePhone(Phone phoneData);

    // get data from db
    List<Phone> getPhone();

    // get data by id
    List<Phone> getIDPhone(int id);

    // update data by id
    Phone updatePhone(Phone phone, int id);

    // delete data by id
    void deletePhone(int id);

}
