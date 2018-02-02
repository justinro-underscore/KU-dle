package com.base.data.interfaces;

import com.base.data.models.User;

import java.util.List;

public class Users {
    /*
    Interface for gson to convert json of users to list of users
     */
    private List<User> users;

    /*
    @Pre: takes in populated list of users
    @Post: sets list of users to passed in users
     */
    public Users(List<User> users) {
        this.users = users;
    }

    /*
    @Return: list of user
     */
    public List<User> getUsers() {
        return users;
    }

    /*
    @Pre: takes in list of users
    @Post: sets list of users to passend in users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
}