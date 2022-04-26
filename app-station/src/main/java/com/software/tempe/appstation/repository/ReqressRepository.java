package com.software.tempe.appstation.repository;

import com.software.tempe.appstation.builder.ReqAPIBuilder;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public class ReqressRepository {
    @Getter
    private ReqAPIBuilder builder;

    public ReqressRepository(ReqAPIBuilder builder) {
        this.builder = builder;
    }
}
