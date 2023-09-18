package mx.edu.utez.sicae.security;

import mx.edu.utez.sicae.models.user.User;
import mx.edu.utez.sicae.models.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usuario=repository.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("EL usuario: "+username+" no existe"));

        return new UserDetailsImpl(usuario);
    }

}
