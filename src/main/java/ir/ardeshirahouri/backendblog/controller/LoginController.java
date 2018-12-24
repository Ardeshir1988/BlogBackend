package ir.ardeshirahouri.backendblog.controller;


import ir.ardeshirahouri.backendblog.dto.UserDTO;
import ir.ardeshirahouri.backendblog.model.UserToken;
import ir.ardeshirahouri.backendblog.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(ResourceConstants.Blog_LOGIN)
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private TokenProvider jwtTokenUtil;

    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public ResponseEntity<?> getToken(@RequestBody UserDTO user){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new UserToken(token));
    }
}
