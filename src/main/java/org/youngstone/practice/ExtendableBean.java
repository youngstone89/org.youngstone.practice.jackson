package org.youngstone.practice;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

public class ExtendableBean {

    public String name;

    public Map<String,String> properties;

    public ExtendableBean(String my_bean) {

        this.name = my_bean;
        this.properties = new HashMap<String,String>();

    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public static void main(String[] args) {

    }

    public void add(String a, String b) {

        this.properties.put(a,b);
    }
}
