package com.vinicius.santos.nonsfwcontentapiplus.model.response;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MetaResponse {

    private final String server = InetAddress.getLocalHost().getHostName();

    public MetaResponse() throws UnknownHostException {
    }

    public String getServer() {
        return server;
    }

}
