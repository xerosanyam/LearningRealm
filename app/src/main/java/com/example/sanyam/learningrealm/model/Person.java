package com.example.sanyam.learningrealm.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by sanyam on 19/3/16.
 */
public class Person extends RealmObject{
    @PrimaryKey
    private int id;
    private String name;


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
