//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//
//import java.io.IOException;
//
//public class CustomJwtAuthenticationFilter extends OncePerRequestFilter {
//    @Autowired
//    private JwtUtil jwtTokenUtil;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//
//        // JWT Token is in the form "Bearer token". Remove Bearer word and
//        // get  only the Token
//        String jwtToken = extractJwtFromRequest(request);
//
//        if (StringUtils.hasText(jwtToken) && jwtTokenUtil.validateToken(jwtToken)) {
//            UserDetails userDetails = new User(jwtTokenUtil.getUsernameFromToken(jwtToken), "",
//                    jwtTokenUtil.getRolesFromToken(jwtToken));
//
//            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
//                    userDetails, null, userDetails.getAuthorities());
//            // After setting the Authentication in the context, we specify
//            // that the current user is authenticated. So it passes the
//            // Spring Security Configurations successfully.
//            SecurityContextHolder.getContext().setAuthentication(auth);
//        } else {
//            System.out.println("Cannot set the Security Context");
//        }
//        chain.doFilter(request, response);
//    }
//
//    private String extractJwtFromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7, bearerToken.length());
//        }
//        return null;
//    }
//}
