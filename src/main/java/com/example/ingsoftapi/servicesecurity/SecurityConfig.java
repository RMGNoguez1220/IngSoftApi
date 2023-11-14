package com.example.ingsoftapi.servicesecurity;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Properties;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity,
                                    AuthenticationManager authenticationManager) throws Exception {

        return httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/api/v1/usuario/all").hasRole("admin")
                .requestMatchers("/api/v1/usuario/create").hasRole("admin")
                .requestMatchers("/api/v1/usuario/update/**").hasRole("moderador")
                .requestMatchers("/api/v1/usuario/delete/**").hasRole("moderador")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();

    }

    @Bean
    UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin1").password(passwordEncoder().encode("1234")).roles("admin").build());
        manager.createUser(User.withUsername("moderator").password(passwordEncoder().encode("Luis1")).roles("moderador").build());
        manager.createUser(User.withUsername("cliente1").password(passwordEncoder().encode("Lluvia1")).roles("cliente").build());
        manager.createUser(User.withUsername("cliente2").password(passwordEncoder().encode("Alex1")).roles("cliente").build());
        manager.createUser(User.withUsername("vendedor1").password(passwordEncoder().encode("Noguez1")).roles("vendedor").build());
        manager.createUser(User.withUsername("vendedor2").password(passwordEncoder().encode("Pollo1")).roles("vendedor").build());
        return  manager;

/*      final Properties users = new Properties();
        users.put("admin","admin1, admin,enabled"); //add whatever other user you need
        users.put("moderator","moderator1, moderador,enabled"); //add whatever other user you need
        users.put("cliente","customer1, customer,enabled"); //add whatever other user you need
        users.put("vendedor","provider1, provider,enabled"); //add whatever other user you need
        return new InMemoryUserDetailsManager(users);*/

/*        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder().encode("1234"))
                .roles("admin")
                .build());
        return manager;*/
    }

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity httpSecurity,
                                                PasswordEncoder passwordEncoder) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    } //close method


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
