package com.web.site.web_site.service;

import com.web.site.web_site.entity.login.LoginRequest;
import com.web.site.web_site.entity.usuario.UsuarioEntity;
import com.web.site.web_site.repository.LoginRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(
            LoginRepository loginRepository,
            PasswordEncoder passwordEncoder
    ){
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioEntity login(LoginRequest request){
        UsuarioEntity usuario = loginRepository.login(request.username());

        if(usuario == null){
            throw new RuntimeException("Usuario não encontrado");
        }

        if(!passwordEncoder.matches(request.senha(),usuario.getSenha()))
        {
            System.out.println(passwordEncoder.matches(request.senha(), usuario.getSenha()));
            throw new RuntimeException("Senha inválida");
        }

        return usuario;
    }
}
