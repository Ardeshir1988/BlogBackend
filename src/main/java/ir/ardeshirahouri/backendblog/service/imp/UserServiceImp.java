package ir.ardeshirahouri.backendblog.service.imp;

import ir.ardeshirahouri.backendblog.model.User;
import ir.ardeshirahouri.backendblog.repository.UserRepository;
import ir.ardeshirahouri.backendblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service(value = "userService")
public class UserServiceImp implements UserDetailsService,UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(s);
        if(user == null){
            throw new UsernameNotFoundException("incorrect username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserPassword(),getAuthority(user));
    }
    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });
        return authorities;
    }
}
