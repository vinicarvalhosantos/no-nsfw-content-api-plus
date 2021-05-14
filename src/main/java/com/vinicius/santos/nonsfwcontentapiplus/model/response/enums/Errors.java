package com.vinicius.santos.nonsfwcontentapiplus.model.response.enums;

import com.vinicius.santos.nonsfwcontentapiplus.model.response.ErrorResponse;

public enum Errors {

    NOT_FOUND(22404, "mesage"),
    INTERNAL_SERVER_ERROR(22500, "message", "exception");

    Errors(int i, String message, String exception) {
    }

    Errors(int i, String mesage) {
    }
}
