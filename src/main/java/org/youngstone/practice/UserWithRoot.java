package org.youngstone.practice;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="user")
public class UserWithRoot {

    public int id;
    public String name;


    public UserWithRoot(int i, String john) {
    this.id = i;
    this.name = john;
    }
}
