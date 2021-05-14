package com.vinicius.santos.nonsfwcontentapiplus.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinicius.santos.nonsfwcontentapiplus.model.response.MetaResponse;
import com.vinicius.santos.nonsfwcontentapiplus.model.response.ResponseErrorBody;
import com.vinicius.santos.nonsfwcontentapiplus.model.response.ResponseSuccessBody;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HtmlResponseWrapper responseWrapper = new HtmlResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, responseWrapper);
        try {
            MetaResponse meta = new MetaResponse();
            response.setContentType("application/json");
            if (((HttpServletResponse) response).getStatus() >= 200 && ((HttpServletResponse) response).getStatus() < 400) {
                ResponseSuccessBody responseBody = new ResponseSuccessBody();
                responseBody.setMeta(meta);
                responseBody.setSuccess(true);
                responseBody.setStatusCode(((HttpServletResponse) response).getStatus());
                if (!response.getContentType().isEmpty())
                    this.successResponse(response, responseWrapper, responseBody);
            } else {
                ResponseErrorBody responseBody = new ResponseErrorBody();
                responseBody.setMeta(meta);
                responseBody.setSuccess(false);
                responseBody.setStatusCode(((HttpServletResponse) response).getStatus());
                this.errorResponse(response, responseWrapper, responseBody);
            }
        } catch (Exception ex) {
            throw new IOException("FAIL_TO_INTERCEPT_RESPONSE", ex);
        }
    }

    @Override
    public void destroy() {
    }

    private void successResponse(ServletResponse response, HtmlResponseWrapper responseWrapper, ResponseSuccessBody responseBody) throws Exception {
        try {
            if (response.getContentType() != null) {
                Object responseContent = responseWrapper.getCaptureAsObject();
                responseBody.getRecords().add(responseContent);
            }
            byte[] bytesResponse = new ObjectMapper().writeValueAsBytes(responseBody);
            response.setContentLength(bytesResponse.length);
            response.getOutputStream().write(bytesResponse);
        } catch (Exception ex) {
            throw new Exception("FAIL_TO_INTERCEPT_RESPONSE", ex);
        }
    }

    private void errorResponse(ServletResponse response, HtmlResponseWrapper responseWrapper, ResponseErrorBody responseBody) throws Exception {
        try {
            if (response.getContentType() != null) {
                Object responseContent = responseWrapper.getCaptureAsObject();
            }
            byte[] bytesResponse = new ObjectMapper().writeValueAsBytes(responseBody);
            response.setContentLength(bytesResponse.length);
            response.getOutputStream().write(bytesResponse);
        } catch (Exception ex) {
            throw new Exception("FAIL_TO_INTERCEPT_RESPONSE", ex);
        }
    }
}
