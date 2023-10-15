package com.app.config;


import com.app.security.CustomAccessDeniedHandler;
import com.app.security.RestAuthenticationEntryPoint;
import com.app.security.TokenAuthenticationFilter;
import com.app.service.serviceImpl.UserDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@SuppressWarnings("deprecation")
public class SecurityConfig {
    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint ;
    @Autowired
    TokenAuthenticationFilter tokenAuthenticationFilter;
    @Bean
    public MappingJackson2HttpMessageConverter jsonConverter() {
        return new MappingJackson2HttpMessageConverter();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return  new UserDetailServices();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception{
        return configuration.getAuthenticationManager();
    }
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());
        http.authorizeRequests(auth ->  auth.requestMatchers("/api/login",  "/api/login1",
                                "/api/logout", "api/register"
                        ,"/"
                        ,"/error"
                        , "/favicon.ico",
                        "/api/**"
//                        , "/**/*.png"
                ).permitAll()
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/company/**").hasRole("COMPANY")
                        .requestMatchers("/user/**").hasAnyRole("USER","ADMIN","COMPANY")
                        .anyRequest().authenticated())
                .exceptionHandling(ex -> ex.authenticationEntryPoint(restAuthenticationEntryPoint)
                        .accessDeniedHandler(accessDeniedHandler()))
                .authenticationProvider(authenticationProvider());
        http.logout(logout -> logout.logoutUrl("/api/logout").addLogoutHandler(new SecurityContextLogoutHandler()));
        http.addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

}
