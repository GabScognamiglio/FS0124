package it.epicode.gestione_dispositivi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity //serve per usare @PreAuthorized sui controller
public class Config {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(http->http.disable());
        httpSecurity.csrf(http->http.disable());
        httpSecurity.sessionManagement(http->http.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers("/api/**").permitAll());
//        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers("/api/users/**").permitAll());


     //   httpSecurity.authorizeHttpRequests(http -> http.requestMatchers(HttpMethod.POST, "api/dipendenti/auth/**").permitAll());
//        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers("**").permitAll());
        httpSecurity.authorizeHttpRequests(http -> http.anyRequest().authenticated());

        return httpSecurity.build();
    }


    //bean per la codifica password da usare in fase di registrazione e login nell' authservice
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
