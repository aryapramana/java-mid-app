package com.software.tempe.appstation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resource_name;
    private String field_name;
    private Object field_value;

    public ResourceNotFoundException(String resource_name, String field_name, Object field_value) {
        super(String.format("%s not found with %s: '%s'", resource_name, field_name, field_value));
        this.resource_name = resource_name;
        this.field_name = field_name;
        this.field_value = field_value;
    }

    public String getResourceName() {
        return resource_name;
    }

    public String getFieldName() {
        return field_name;
    }

    public Object getFieldValue() {
        return field_value;
    }
}
