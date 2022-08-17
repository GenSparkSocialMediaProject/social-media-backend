package com.speakr.controller;

import com.speakr.dao.UserDAO;
import com.speakr.entity.User;
import com.speakr.service.JwtUserDetailsImp;
import com.speakr.util.JwtTokenUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    protected final Log logger = LogFactory.getLog(getClass());

    final UserDAO userDAO;
    final AuthenticationManager authenticationManager;
    final JwtUserDetailsImp userDetailsService;
    final JwtTokenUtil jwtTokenUtil;

    public AuthenticationController(UserDAO userDAO, AuthenticationManager authenticationManager,
                                    JwtUserDetailsImp userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.userDAO = userDAO;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam("username") String username,
                                       @RequestParam("password") String password) {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username
                    , password));
            if (auth.isAuthenticated()) {
                logger.info("Logged In");
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                String token = jwtTokenUtil.generateToken(userDetails);
                responseMap.put("error", false);
                responseMap.put("message", "Logged In");
                responseMap.put("token", token);
                return ResponseEntity.ok(responseMap);
            } else {
                responseMap.put("error", true);
                responseMap.put("message", "Invalid Credentials");
                return ResponseEntity.status(401).body(responseMap);
            }
        } catch (DisabledException e) {
            e.printStackTrace();
            responseMap.put("error", true);
            responseMap.put("message", "User is disabled");
            return ResponseEntity.status(500).body(responseMap);
        } catch (BadCredentialsException e) {
            responseMap.put("error", true);
            responseMap.put("message", "Invalid Credentials");
            return ResponseEntity.status(401).body(responseMap);
        } catch (Exception e) {
            e.printStackTrace();
            responseMap.put("error", true);
            responseMap.put("message", "Something went wrong");
            return ResponseEntity.status(500).body(responseMap);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestParam("username") String username,
                                      @RequestParam("displayName") String displayName,
                                      @RequestParam("password") String password) {
        Map<String, Object> responseMap = new HashMap<>();
        User user = new User();
        user.setUserName(username);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setRole("USER");
        user.setDisplayName(displayName);
        user.setJoinDate(new Date());

        UserDetails userDetails = userDetailsService.createUserDetails(username, password);
        String token = jwtTokenUtil.generateToken(userDetails);

        userDAO.save(user);
        responseMap.put("error", false);
        responseMap.put("username", username);
        responseMap.put("message", "Account created successfully");
        responseMap.put("token", token);
        return ResponseEntity.ok(responseMap);
    }

}
