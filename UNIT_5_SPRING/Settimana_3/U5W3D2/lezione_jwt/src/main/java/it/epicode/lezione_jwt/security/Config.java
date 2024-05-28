package it.epicode.lezione_jwt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity //serve per usare @PreAuthorized sui controller
public class Config {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(http -> http.disable());
        httpSecurity.csrf(http -> http.disable());
        httpSecurity.sessionManagement(http -> http.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.cors(Customizer.withDefaults());
        //permette l'accesso a tutti dei servizi con endpoint /api/users e metodi get (naturalmente dopo l'autenticazione)

        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers("/api/**").permitAll());
//        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers("/api/users/**").permitAll());


        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers(HttpMethod.POST, "/auth/**").permitAll());
//        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers("**").permitAll());
        //nega l'accesso a qualsiasi servizio che non sia get e path /api/users
        httpSecurity.authorizeHttpRequests(http -> http.anyRequest().authenticated());


        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("*")); //chiunque da qualsiasi server
        corsConfiguration.setAllowedMethods(List.of("*"));  // può utilizzare qualsiasi metodo

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); //su qualsiasi endpoint

        return source;
    }

}
