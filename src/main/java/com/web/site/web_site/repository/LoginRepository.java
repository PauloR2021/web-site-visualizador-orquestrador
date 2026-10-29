package com.web.site.web_site.repository;

import com.web.site.web_site.entity.usuario.UsuarioEntity;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    private final JdbcTemplate jdbcTemplate;

    public LoginRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public UsuarioEntity login(String username){
        String sql = """
                SELECT
                    u.ID,
                    u.NOME,
                    u.SENHA,
                    u.USERNAME,
                    u.PERFIL,
                    u.PRIMEIRO_ACESSO,
                    u.SENHA_ALTERADA,
                    u.DT_EXPIRACAO
                FROM USUARIO u
                WHERE u.USERNAME = ?
              """;
        try{
            return jdbcTemplate.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<>(UsuarioEntity.class),
                    username
            );
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
