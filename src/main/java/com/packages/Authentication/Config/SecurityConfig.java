package com.packages.Authentication.Config;
import com.packages.Authentication.Service.AuthenticationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // Saying server to ignore built in filter chains and access our own security chain
public class SecurityConfig {
    private final AuthenticationUserService userDetailsService;

    public SecurityConfig(AuthenticationUserService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean // returning a Bean with Customized SecurityFilterChain
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//      Disabling the csrf token
        http.csrf(customizer -> customizer.disable());

//      Asking for Authorization on all the request, if any exceptions include it
        http.authorizeHttpRequests(request -> request
                .requestMatchers("/customerRegister", "/adminRegister", "/sellerRegister").permitAll() // No auth needed
                .requestMatchers("/").hasRole("CUSTOMER") // Only CUSTOMER can access "/"
                .anyRequest().authenticated() // Everything else needs authentication
        );

//      form Login inbuilt in Spring Security
//      http.formLogin(Customizer.withDefaults());

//      Allowing login through postman or API
        http.httpBasic(Customizer.withDefaults());

//      We are going with stateless for session, and there are other options also, just explore it
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // Password deEncryptor
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }



}
