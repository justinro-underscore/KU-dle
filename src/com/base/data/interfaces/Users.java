package com.base.data.interfaces;

import com.base.data.models.User;

import java.util.*;

/*
* Interface for gson to convert json of users to a HashMap of users
 */
public class Users {
    /*
    * @pre: Takes in a hashmap of users with username as key
    * @post: assign local variable to passed in value
    * @return: nothing
     */
    private HashMap<String, User> user_list = new HashMap<>();

    /*
    * @pre: takes in populated HashMap of users
    * @post: sets HashMap of users to passed in users
    * @return: nothing
     */
    public Users(HashMap<String, User> users) {
        this.user_list = users;
    }

    /*
    * @pre: nothing
    * @post: nothing
    * @return: users
     */
    public HashMap<String, User> getUsers() {
        return this.user_list;
    }

    /*
    * @pre: takes in hashmap of users
    * @post: sets hashmap of users to passed in users
    * @return: nothing
     */
    public void setUsers(HashMap<String, User> users) {
        this.user_list = users;
    }
}
