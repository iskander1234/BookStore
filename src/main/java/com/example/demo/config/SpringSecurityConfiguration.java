//package com.example.demo.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfiguration {
//    @Autowired
//    CustomUserDetailsService customUserDetailsService;
//
//    @Autowired
//    private CustomJwtAuthenticationFilter customJwtAuthenticationFilter;
//
//    @Autowired
//    private JwtAuthenticationEntryPoint unauthorizedHandler;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        // We don't need CSRF for this example
//        httpSecurity.csrf().disable()
//                .authorizeRequests().antMatchers("/helloadmin").hasRole("ADMIN")
//                .antMatchers("/hellouser").hasAnyRole("ADMIN","USER")
//                .antMatchers("/authenticate", "/v2/api-docs/**", "/configuration/**", "/swagger-resources/**",
//                        "/swagger-ui.html/**", "/webjars/**", "/api-docs/**", "/register").permitAll().anyRequest().authenticated()
//                .and().exceptionHandling()
//                .authenticationEntryPoint(unauthorizedHandler).and().
//                sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        httpSecurity.addFilterBefore(customJwtAuthenticationFilter,
//                UsernamePasswordAuthenticationFilter.class);
//    }
//}
