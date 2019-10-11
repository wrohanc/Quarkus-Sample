package com.ro.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "admin_user")
public class User {
    @Id
    @Column(name = "admin_id")
    private int userId;
    @Column(name="first_name")
    @NotBlank(message="First name may not be blank")
    private String firstName;
    @Column(name="last_name")
    @NotNull
    @NotBlank(message="Last name may not be blank")
    private String lastName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
