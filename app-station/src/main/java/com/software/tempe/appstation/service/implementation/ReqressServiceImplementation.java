package com.software.tempe.appstation.service.implementation;

import com.software.tempe.appstation.builder.ReqAPIBuilder;
import com.software.tempe.appstation.model.Reqress;
import com.software.tempe.appstation.repository.ReqressRepository;
import com.software.tempe.appstation.service.ReqService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Component
public class ReqressServiceImplementation implements ReqService {

    private final ReqressRepository repository;

    @Autowired
    public ReqressServiceImplementation(ReqressRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Reqress getReqress(int id) {

        Reqress reqress_data = repository.getBuilder().buildReqAPI().get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/users/")
                        .path(String.valueOf(id))
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Reqress.class)
                .block();

        return reqress_data;
    }
}
