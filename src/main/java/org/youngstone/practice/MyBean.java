package org.youngstone.practice;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name","id"})
public class MyBean {

    public int id;
    private String name;

    public MyBean(int i, String my_bean) {

        this.id = i;
        this.name = my_bean;
    }

    @JsonGetter("name")
    public String getTheName(){
        return name;
    }


}
