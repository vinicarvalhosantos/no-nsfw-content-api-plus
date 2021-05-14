package com.vinicius.santos.nonsfwcontentapiplus.model.response;

import java.util.ArrayList;
import java.util.List;

public class ResponseSuccessBody extends Response {

    private final List<Object> records = new ArrayList<>();

    public ResponseSuccessBody() {
    }

    public List<Object> getRecords() {
        return records;
    }

}
