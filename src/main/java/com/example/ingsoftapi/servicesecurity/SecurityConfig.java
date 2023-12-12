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
                .requestMatchers("/v3/api-docs/*", "/swagger-ui/*", "/swagger-ui.html").permitAll()
                .requestMatchers("/api/v1/usuario/all").hasRole("admin")
                .requestMatchers("/api/v1/usuario/create").hasRole("cliente")
                .requestMatchers("/api/v1/usuario/update/**").hasRole("cliente")
                .requestMatchers("/api/v1/usuario/delete/**").hasRole("admin")

                .requestMatchers("api/v1/carrito_compra/all").hasRole("admin")
                .requestMatchers("api/v1/carrito_compra/create").hasRole("admin")
                .requestMatchers("api/v1/carrito_compra/update/**").hasRole("admin")
                .requestMatchers("api/v1/carrito_compra/delete/**").hasRole("admin")

                .requestMatchers("api/v1/carrito_producto/all").hasRole("admin")
                .requestMatchers("api/v1/carrito_producto/create").hasRole("admin")
                .requestMatchers("api/v1/carrito_producto/**").hasRole("admin")
                .requestMatchers("api/v1/carrito_producto/**").hasRole("admin")

                .requestMatchers("api/v1/comprador/all").hasRole("moderador")
                .requestMatchers("api/v1/comprador/create").hasRole("moderador")
                .requestMatchers("api/v1/comprador/update/**").hasRole("moderador")
                .requestMatchers("api/v1/comprador/delete/**").hasRole("moderador")

                .requestMatchers("api/v1/inventario/create").hasRole("moderador")
                .requestMatchers("api/v1/inventario/update/**").hasRole("moderador")
                .requestMatchers("api/v1/inventario/delete/**").hasRole("moderador")

                .requestMatchers("api/v1/Notificacion/all").hasRole("cliente")
                .requestMatchers("api/v1/Notificacion/create").hasRole("cliente")
                .requestMatchers("api/v1/Notificacion/update/**").hasRole("cliente")
                .requestMatchers("api/v1/Notificacion/delete/**").hasRole("cliente")

                .requestMatchers("api/v1/Orden_compra/all").hasRole("moderador")
                .requestMatchers("api/v1/Orden_compra/create").hasRole("moderador")
                .requestMatchers("api/v1/Orden_compra/update/**").hasRole("moderador")
                .requestMatchers("api/v1/Orden_compra/delete/**").hasRole("moderador")

                .requestMatchers("api/v1/orden_producto/all").hasRole("moderador")
                .requestMatchers("api/v1/orden_producto/create").hasRole("moderador")
                .requestMatchers("api/v1/orden_producto/update/**").hasRole("moderador")
                .requestMatchers("api/v1/orden_producto/delete/**").hasRole("moderador")

                .requestMatchers("api/v1/producto/all").hasRole("cliente")
                .requestMatchers("api/v1/producto/create").hasRole("admin")
                .requestMatchers("api/v1/producto/update/**").hasRole("admin")
                .requestMatchers("api/v1/producto/delete/**").hasRole("admin")

                .requestMatchers("api/v1/resena_producto/all").hasRole("cliente")
                .requestMatchers("api/v1/resena_producto/create").hasRole("cliente")
                .requestMatchers("api/v1/resena_producto/update/**").hasRole("cliente")
                .requestMatchers("api/v1/resena_producto/delete/**").hasRole("cliente")

                .requestMatchers("api/v1/vendedor/all").hasRole("admin")
                .requestMatchers("api/v1/vendedor/create").hasRole("admin")
                .requestMatchers("api/v1/vendedor/update/**").hasRole("admin")
                .requestMatchers("api/v1/vendedor/delete/**").hasRole("admin")
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
        manager.createUser(User.withUsername("LuisAR").password(passwordEncoder().encode("Luis1")).roles("moderador").build());
        manager.createUser(User.withUsername("Lluvia").password(passwordEncoder().encode("Lluvia1")).roles("cliente").build());
        manager.createUser(User.withUsername("AlexMP").password(passwordEncoder().encode("Alex1")).roles("cliente").build());
        manager.createUser(User.withUsername("RickGN").password(passwordEncoder().encode("Noguez1")).roles("vendedor").build());
        manager.createUser(User.withUsername("DulceST").password(passwordEncoder().encode("Dulce1")).roles("vendedor").build());
        return manager;

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
