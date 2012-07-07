package com.habuma.spitter.persistence;


import com.habuma.spitter.domain.Spitter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JdbcSpitterDao implements SpitterDao {

    @Inject
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*   @Inject
  @Named("dataSource")
  private DataSource dataSource;*/


    /*private static final String SQL_INSERT_SPITTER =
            "insert into spitter(username, password, fullname, email, update_by_email) values(?, ?, ?, ?, ?)";

    public void addSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
  *//*      spitter.setId(queryForIdentity());*//*
    }*/

    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password, fullname) " +
                    "values(:username, :password, :fullname)";

    public void addSpitter(Spitter spitter) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", spitter.getUsername());
        params.put("password", spitter.getPassword());
        params.put("fullname", spitter.getFullName());

        jdbcTemplate.update(SQL_INSERT_SPITTER, params);

    }

    private static final String SQL_SELECT_SPITTER_BY_ID =
            "select id, username, fullname, password from spitter where id=?";

    public Spitter getSpitterById(long id) {
        return jdbcTemplate.queryForObject(
                SQL_SELECT_SPITTER_BY_ID,
                new ParameterizedRowMapper<Spitter>() {
                    public Spitter mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Spitter spitter = new Spitter();
                        spitter.setId(rs.getLong(1));
                        spitter.setUsername(rs.getString(2));
                        spitter.setPassword(rs.getString(3));
                        spitter.setFullName(rs.getString(4));
                        return spitter;
                    }
                },
                id
        );
    }

    private static final String SQL_UPDATE_SPITTER =
            "update spitter set username = ?, password = ?, fullname = ? where id=?";

    public void saveSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_UPDATE_SPITTER,
                new Object[]{spitter.getUsername(), spitter.getPassword(),
                        spitter.getFullName(), spitter.getId()});
    }


}
