package com.ro.learn.service;

import com.ro.learn.model.User;
import io.agroal.api.AgroalDataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    AgroalDataSource defaultDataSource;
    @Inject
    EntityManager em;

    public List<User> getUsers() {
        List<User> users = null;
        try (Connection connection = defaultDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT admin_id, first_name FROM admin_user");
             ResultSet rs = ps.executeQuery()){
            users = new ArrayList<>(100);
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("admin_id"));
                user.setFirstName(rs.getString("first_name"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Transactional
    public void createUser(User user) {
        em.persist(user);
    }
}
