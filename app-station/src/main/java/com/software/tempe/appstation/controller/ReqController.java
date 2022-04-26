package com.software.tempe.appstation.controller;

import com.software.tempe.appstation.model.Reqress;
import com.software.tempe.appstation.service.ReqService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/req")
public class ReqController {
    private ReqService service;
    private Map<String, Object> response_body_json;
    private Reqress reqress_data;

    public ReqController(ReqService service) {
        super();
        this.service = service;
    }

    @GetMapping("{id}")
    public Map<String, Object> getIndReq(@PathVariable int id)  {
        response_body_json = new HashMap<>();

        try {
            reqress_data = service.getReqress(id);
            response_body_json.put("response", reqress_data);
        } catch (Exception e)   {
            response_body_json.put("message", e.getMessage());
        }

        return response_body_json;

    }

}
