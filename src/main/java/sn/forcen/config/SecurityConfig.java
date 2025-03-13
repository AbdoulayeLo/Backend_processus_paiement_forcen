package sn.forcen.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/***
 * @author AbdouDevIT
 */
    @EnableWebSecurity
    @Configuration
    @RequiredArgsConstructor
    public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private  AuthenticationProvider authenticationProvider;  //final doit avoir

    @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/public/**").permitAll() // Autoriser l'accès public
//                        .anyRequest().authenticated() // Toutes les autres routes nécessitent une authentification
//                )
//                .formLogin((form) -> form
//                        .loginPage("/login") // Personnaliser la page de login
//                        .permitAll()
//                )
//                .logout((logout) -> logout.permitAll()); // Autoriser la déconnexion

//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();

            http
                    .csrf()         //pour la verification
                    .disable()
                    .authorizeHttpRequests()
                    .requestMatchers("")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authenticationProvider(authenticationProvider)
                    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

            return http.build();
    }
}
