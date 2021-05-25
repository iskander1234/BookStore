//package com.example.demo.controller;
//
//import com.example.demo.config.CustomUserDetailsService;
//import com.example.demo.config.JwtUtil;
//import com.example.demo.controller.request.AuthenticationRequest;
//import com.example.demo.controller.response.AuthenticationResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//public class AuthenticationController {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    @Autowired
//    private JwtUtil jwtTokenUtil;
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
//            throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//
//        final String token = jwtTokenUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new AuthenticationResponse(token));
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
//        return ResponseEntity.ok(userDetailsService.save(user));
//    }
//
//}
