package com.software.tempe.appstation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Reqress {
    @JsonProperty("data")
    @Getter
    @Setter
    private Data data;

    @JsonProperty("support")
    @Getter
    @Setter
    private Support support;
}
