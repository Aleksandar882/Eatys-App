//package com.example.eatys_app.config;
//
//import com.example.eatys_app.service.KorisnikService;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomUsernamePasswordAuthenticationProvider implements AuthenticationProvider {
//
//    private final KorisnikService korisnikService;
//    private final PasswordEncoder passwordEncoder;
//
//    public CustomUsernamePasswordAuthenticationProvider(KorisnikService korisnikService, PasswordEncoder passwordEncoder) {
//        this.korisnikService = korisnikService;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        if ("".equals(username) || "".equals(password)) {
//            throw new BadCredentialsException("Invalid Credentials");
//        }
//
//        UserDetails userDetails = this.korisnikService.loadUserByUsername(username);
//
//        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
//            throw new BadCredentialsException("Password is incorrect!");
//        }
//        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
//
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return aClass.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
