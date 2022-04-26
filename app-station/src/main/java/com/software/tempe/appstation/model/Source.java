package com.software.tempe.appstation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import reactor.util.annotation.Nullable;

@Data
public class Source {

    @Nullable
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}
