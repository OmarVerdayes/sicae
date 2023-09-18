package mx.edu.utez.sicae.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
