package com.example.User_Management_Netflx.service;

import com.example.User_Management_Netflx.entity.JwtRequest;
import com.example.User_Management_Netflx.entity.JwtResponse;
import com.example.User_Management_Netflx.entity.User;
import com.example.User_Management_Netflx.repo.UserRepo;
import com.example.User_Management_Netflx.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public JwtService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String password = jwtRequest.getPassword();
        authenticate(userName,password);

        final  UserDetails userDetails= loadUserByUsername(userName);

        String newGeneratedToken =jwtUtil.generateToken(userDetails);
        User user = userRepo.findById(userName).get();
        return new JwtResponse(user,newGeneratedToken);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=  userRepo.findById(username).get();
        if (user!=null){
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    getAuthorites(user)

            );
        }else {
throw new UsernameNotFoundException("Username is not Valid");
        }
    }

    private Set getAuthorites(User user){
        Set authorities= new HashSet();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        });
        return authorities;
    }

    private void authenticate(String userName, String userPassword)throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,userPassword));
        }catch (DisabledException e){
            throw new Exception("User is disabled");
        }catch(BadCredentialsException e){
            throw new Exception("Bad Credential from user");
        }

    }
}
