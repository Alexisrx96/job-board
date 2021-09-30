package sv.edu.udb.www.jobboard.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //var u = userDao.getUserByEmail(s);
        //var grantedAuthorities = new ArrayList<GrantedAuthority>();
        //grantedAuthorities.add(new SimpleGrantedAuthority(u.getIdRol().getRol()));
        //return new User(u.getEmail(),u.getPassword(), grantedAuthorities);
        return new User("foo","foo", new ArrayList<>());
    }
}
