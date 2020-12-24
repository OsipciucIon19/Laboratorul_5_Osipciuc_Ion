package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("SELECT * FROM _user",(response, rowNumber) ->
                new User(response.getLong("id"),
                        response.getString("first_name"),
                        response.getString("last_name"),
                        response.getString("mail")));
        return userList;
    }

    public void save(User user) {
        jdbcTemplate.update("INSERT INTO _user(id, first_name, last_name, mail) VALUES (?, ?, ?, ?)",
                user.getId(), user.getFirstName(), user.getLastName(), user.getMail());
    }

    public void updateUser(long id, User user) {
        jdbcTemplate.update("UPDATE _user SET mail = ? WHERE id = ?",
                user.getMail(), id);
    }

    public void deleteUser(long id) {
        jdbcTemplate.update("DELETE FROM _user WHERE id = ?", id);
    }
}
