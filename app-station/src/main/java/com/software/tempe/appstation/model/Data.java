package com.software.tempe.appstation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


public class Data {
    @JsonProperty("id")
    @Setter
    @Getter
    private int id;

    @JsonProperty("email")
    @Setter
    @Getter
    private String email;

    @JsonProperty("first_name")
    @Setter
    @Getter
    private String first_name;

    @JsonProperty("last_name")
    @Setter
    @Getter
    private String last_name;

    @JsonProperty("avatar")
    private String avatar;
}
