package com.koushal.todolistapplication.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    //here 'withDefaultPasswordEncoder' is deprecated, but we can create username and password like this also.
//    @Bean
//    public InMemoryUserDetailsManager createUserDetailsManager(){
//        UserDetails userDetails= User
//                .withDefaultPasswordEncoder()
//                .username("koushal")
//                .password("dummy")
//                .build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }


    //here we are using passEncoder method of User class
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        UserDetails userDetails1 = createUser("Koushal","dummy");
        UserDetails userDetails2 = createUser("Ram","dummy");
        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

    private UserDetails createUser(String username,String password) {
        UserDetails userDetails= User
                .builder()
                .passwordEncoder((input)-> passwordEncoderFunction().encode(input))
                .username(username)
                .password(password)
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoderFunction(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //this two feature was automatically provided by spring security but because we are
        //using custom security filter chain so, here we need to tell spring what all thing we need
        //like first statement is about all endpoint requests should be protected
        //and second is about login form
        http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());

        //By default, spring security disables use of csrf and frames and this check we need to disable for using h2 databse console
        http.csrf(AbstractHttpConfigurer::disable);
        http.headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        return http.build();
    }

}
