package com.packages.Authentication.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Saying server to ignore built in filter chains and access our own security chain
public class SecurityConfig {

    @Bean // returning a Bean with Customized SecurityFilterChain
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//      Disabling the csrf token
        http.csrf(customizer -> customizer.disable());

//      Asking for Authorization on all the request, if any exceptions include it
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());

//      form Login inbuilt in Spring Security
//      http.formLogin(Customizer.withDefaults());

//      Allowing login through postman or API
        http.httpBasic(Customizer.withDefaults());

//      We are going with stateless for session, and there are other options also, just explore it
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }





}
