package com.addtech.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        Object error = request.getAttribute("error");
        if (Objects.nonNull(error)) {
            customResponse(request, response, error);
            return;
        }
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Unauthorized");
    }

    private void customResponse(HttpServletRequest request, HttpServletResponse response, Object error) throws IOException {
        String errorMessage = error.toString();

        ObjectMapper mapper = new ObjectMapper();

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", errorMessage);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(mapper.writeValueAsString(errorResponse));
    }
}
