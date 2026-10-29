package com.web.site.web_site.entity.log;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class LogWeb {
    private Integer id;
    private String usuario;
    private String nomeUsuario;
    private String perfil;
    private String ativiade;

    private LocalDateTime data;

    private String ipOrigem;
    private String hostname;
    private String url;
    private String navegador;
    private String status;

    private Integer tempoSessao;
}
