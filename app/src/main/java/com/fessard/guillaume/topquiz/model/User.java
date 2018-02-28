package com.fessard.guillaume.topquiz.model;

/**
 * Created by Guillaume Fessard on 31/10/2017.
 */

public class User {
    private String mFirstname;

    public String getFirstname() {
        return mFirstname;
    }

    public void setFirstname(String firstname) {
        mFirstname = firstname;
    }

    @Override
    public String toString() {
        return "User{" +
                "mFirstname='" + mFirstname + '\'' +
                '}';
    }
}