package com.base.data.interfaces;

import com.base.data.models.User;

import java.util.*;

public class Users {
    /*
    Interface for gson to convert json of users to a HashMap of users
     */
    private HashMap<String, User> user_list = new HashMap<>();

    /*
    @Pre: takes in populated HashMap of users
    @Post: sets HashMap of users to passed in users
     */
    public Users(HashMap<String, User> users) {
        this.user_list = users;
    }

    /*
    @Return: HashMap of user
     */
    public HashMap<String, User> getUsers() {
        return this.user_list;
    }

    /*
    @Pre: takes in hashmap of users
    @Post: sets hashmap of users to passend in users
     */
    public void setUsers(HashMap<String, User> users) {
        this.user_list = users;
    }
}
