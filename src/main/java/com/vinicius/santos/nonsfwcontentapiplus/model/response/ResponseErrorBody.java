package com.vinicius.santos.nonsfwcontentapiplus.model.response;

import java.util.ArrayList;
import java.util.List;

public class ResponseErrorBody extends Response {

    private List<Object> errors = new ArrayList<>();

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

}
