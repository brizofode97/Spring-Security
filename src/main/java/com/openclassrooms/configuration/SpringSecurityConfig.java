package com.openclassrooms.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    private final CustumUserDetailsService custumUserDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((auth) -> {
                    auth.requestMatchers("/admin").hasRole("ADMIN"); // Permet de matcher un chemin à un role
                    auth.requestMatchers("/user").hasRole("USER");
                    auth.anyRequest().authenticated(); // Permet de dire que toute requete doit etre authentifié pour accéder aux URL
                })
                .formLogin(Customizer.withDefaults()) // Page de connexion par défaut fourni par Spring Sécurity
                .oauth2Login(Customizer.withDefaults()) // Permet d'ajouter le bouton de redirection github
                .build(); // Construction de l'objet
    }

    @Bean
    public UserDetailsService user() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                .roles("USER").build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("USER", "ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder)
    throws Exception{
        AuthenticationManagerBuilder authentificationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authentificationManagerBuilder.userDetailsService(custumUserDetailsService);
        return authentificationManagerBuilder.build();
    }

}
