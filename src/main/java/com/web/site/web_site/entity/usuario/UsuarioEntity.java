package com.web.site.web_site.entity.usuario;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class UsuarioEntity {
    private Long id;
    private String nome;
    private String username;
    private String senha;
    private String perfil;
    private Boolean ativo;
    private Boolean primeiroAcesso;
    private Boolean senhaAlterada;
    private LocalDateTime dtCriacao;
    private LocalDateTime dtExpiracao;
    private LocalDateTime dtUltimoLogin;

}
