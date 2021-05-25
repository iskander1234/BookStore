//package com.example.demo.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.net.MediaType;
//
//import javax.naming.AuthenticationException;
//import java.io.IOException;
//import java.util.Collections;
//
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response,
//                         AuthenticationException authException) throws IOException, ServletException {
//
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//
//        String message;
//
//        if (authException.getCause() != null) {
//            message = authException.getCause().toString() + " " + authException.getMessage();
//        } else {
//            message = authException.getMessage();
//        }
//
//        byte[] body = new ObjectMapper().writeValueAsBytes(Collections.singletonMap("error", message));
//
//        response.getOutputStream().write(body);
//    }
//}
