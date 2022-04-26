package com.software.tempe.appstation.controller;

import com.software.tempe.appstation.model.Phone;
import com.software.tempe.appstation.service.PhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/phone/data")
public class PhoneController {
    // constructor dependency injection
    private final PhoneService service;
    private Map<String, Object> response_body_json;

    public PhoneController(PhoneService service) {
        super();
        this.service = service;
    }

//    @PostMapping
//    public ResponseEntity<Phone> savePhone(@RequestBody Phone phone) {
//        return new ResponseEntity<Phone>(service.savePhone(phone), HttpStatus.valueOf(HttpStatus.OK.value()));
//    }

    @PostMapping
    public Map<String, Object> savePhone(@RequestBody Phone phone)  {
        response_body_json = new HashMap<>();

        try {
            service.savePhone(phone);
            response_body_json.put("status", HttpStatus.OK.value());
            response_body_json.put("message", HttpStatus.OK);
        } catch (Exception e)   {
            response_body_json.put("status", HttpStatus.BAD_REQUEST.value());
            response_body_json.put("message", e.getMessage());
        }

        return response_body_json;

    }

    @GetMapping
    public Map<String, Object> getPhone()   {
        response_body_json = new HashMap<>();

        try {
            List<Phone> phone_data = service.getPhone();
            response_body_json.put("status", HttpStatus.OK.value());
            response_body_json.put("message", HttpStatus.OK);
            response_body_json.put("total", phone_data.size());
            response_body_json.put("data", phone_data);
        } catch (Exception e)   {
            response_body_json.put("status", HttpStatus.BAD_REQUEST.value());
            response_body_json.put("message", e.getMessage());
        }

        return response_body_json;

    }

    @GetMapping("{id}")
    public Map<String, Object> getIDPhone(@PathVariable int id) {
        response_body_json = new HashMap<>();

        try {
            List<Phone> phone_data = service.getIDPhone(id);
            response_body_json.put("status", HttpStatus.OK.value());
            response_body_json.put("message", HttpStatus.OK);
            response_body_json.put("total", phone_data.size());
            response_body_json.put("data", phone_data);
        } catch (Exception e)   {
            response_body_json.put("status", HttpStatus.BAD_REQUEST.value());
            response_body_json.put("message", e.getMessage());
        }

        return response_body_json;

    }

    @PutMapping("{id}")
    public Map<String, Object> updatePhone(@RequestBody Phone phone, @PathVariable int id)  {
        response_body_json = new HashMap<>();

        try {
            Phone phone_data = service.updatePhone(phone, id);
            response_body_json.put("status", HttpStatus.OK.value());
            response_body_json.put("message", HttpStatus.OK);
            response_body_json.put("data", phone_data);
        } catch (Exception e)   {
            response_body_json.put("status", HttpStatus.BAD_REQUEST.value());
            response_body_json.put("message", e.getMessage());
        }

        return response_body_json;

    }

    @DeleteMapping("{id}")
    public Map<String, Object> deletePhone(@PathVariable int id)    {
        response_body_json = new HashMap<>();

        try {
            service.deletePhone(id);
            response_body_json.put("status", HttpStatus.OK.value());
            response_body_json.put("message", HttpStatus.OK);
        } catch (Exception e) {
            response_body_json.put("status", HttpStatus.BAD_REQUEST.value());
            response_body_json.put("message", e.getMessage());
        }

        return response_body_json;
    }


}
