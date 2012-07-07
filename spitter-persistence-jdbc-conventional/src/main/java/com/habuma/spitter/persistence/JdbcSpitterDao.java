package com.habuma.spitter.persistence;


import com.habuma.spitter.domain.Spitter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class JdbcSpitterDao implements SpitterDao {

    private static final String SQL_INSERT_SPITTER =
            "insert into spitter(username, password, fullname, email, update_by_email) values(?, ?, ?, ?, ?)";

    @Inject
    @Named("dataSource")
    private DataSource dataSource;

    public void addSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_SPITTER);
            stmt.setString(1, spitter.getUsername());
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFullName());
            stmt.setString(4, spitter.getEmail());
            stmt.setBoolean(5, spitter.isUpdateByEmail());

            stmt.execute();
        } catch (SQLException e) {
            // do something...not sure what, though
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // I'm even less sure about what todo here
            }
        }
    }

    private static final String SQL_UPDATE_SPITTER =
            "update spitter set username = ?, password = ?, fullname = ? where id=?";

    public void saveSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection();

            stmt = conn.prepareStatement(SQL_UPDATE_SPITTER);
            stmt.setString(1, spitter.getUsername());
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFullName());
            stmt.setLong(4, spitter.getId());
            stmt.execute();
        } catch (SQLException e) {
            // Still not sure what I'm supposed todo here
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // or here
            }
        }
    }


    private static final String SQL_SELECT_SPITTER =
            "select id, username, fullname, password from spitter where id=?";

    public Spitter getSpitterById(long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_SPITTER);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            Spitter spitter = null;
            if (rs.next()) {
                spitter = new Spitter();
                spitter.setId(rs.getLong("id"));
                spitter.setUsername(rs.getString("username"));
                spitter.setPassword(rs.getString("password"));
                spitter.setFullName(rs.getString("fullname"));
            }
            return spitter;
        } catch (SQLException e) {
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return null;
    }
}
