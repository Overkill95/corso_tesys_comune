package com.controller.controller;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import com.controller.dto.UserDto;
import com.controller.entity.AuthenticationRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@RestController
public class AuthenticationController {

	@Autowired
    private  AuthenticationManager authenticationManager;
	
    private final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();
    
    private SecurityContextRepository securityContextRepository =
            new HttpSessionSecurityContextRepository();

 
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public UserDto createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        
//        SecurityContextHolder.getContext().setAuthentication(authentication); 
//        HttpSession session = request.getSession();
//        securityContextRepository.saveContext(SecurityContextHolder.getContext(), request, response);
                
        
//        SecurityContext sc = SecurityContextHolder.createEmptyContext();
//        sc.setAuthentication(authentication);
//        HttpSession session = request.getSession(true);
//        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);
//        SecurityContextHolder.setContext(sc);
//        SecurityContextHolder.getContextHolderStrategy().setContext(sc);
//        securityContextRepository.saveContext(SecurityContextHolder.getContext(), request, response);
        
        SecurityContext context = securityContextHolderStrategy.createEmptyContext();
        context.setAuthentication(authentication); 
        securityContextHolderStrategy.setContext(context);
        securityContextRepository.saveContext(context, request, response);
        
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        
        UserDto userDto = new UserDto();
        userDto.setUsername(userPrincipal.getUsername());
        userDto.setAuthenticated(authentication.isAuthenticated());
        
        Iterator<? extends GrantedAuthority> it = authentication.getAuthorities().iterator();
        
        while(it.hasNext()) {
        	GrantedAuthority authority = it.next();
        	userDto.addRole(authority.getAuthority());
        }
        
        userDto.setSessionId(RequestContextHolder.currentRequestAttributes().getSessionId());
        
        return userDto;
        
    }
}
