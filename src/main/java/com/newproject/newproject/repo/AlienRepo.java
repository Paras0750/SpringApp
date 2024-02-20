package com.newproject.newproject.repo;

import java.sql.ResultSet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.SQLException;

import com.newproject.newproject.model.Alien;

@Component
public class AlienRepo {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Alien alien) {
        String query = "insert into alien (id,name,tech) values (?, ?, ?)";
        int rows = jdbcTemplate.update(query, alien.getId(), alien.getName(), alien.getTech());
        System.out.println("Alien created: " + rows);
    }

    public List<Alien> getOne(int id) {
        String query = "select * from alien where id = " + id;

        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            @SuppressWarnings("null")
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien alien = new Alien();
                alien.setId(rs.getInt(1));
                alien.setName(rs.getString(2));
                alien.setTech(rs.getString(3));

                return alien;
            }
        };

        List<Alien> aliens = jdbcTemplate.query(query, mapper);

        return aliens;


    }

    public List<Alien> findAll() {
        String query = "select * from alien";

        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            @SuppressWarnings("null")
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien alien = new Alien();
                alien.setId(rs.getInt(1));
                alien.setName(rs.getString(2));
                alien.setTech(rs.getString(3));

                return alien;
            }
        };

        List<Alien> aliens = jdbcTemplate.query(query, mapper);

        return aliens;

        // return jdbcTemplate.query(query, (rs, rowNum) -> {
        // Alien alien = new Alien();
        // alien.setId(rs.getInt(1));
        // alien.setName(rs.getString(2));
        // alien.setTech(rs.getString(3));

        // return alien;

        // });

    }
}
