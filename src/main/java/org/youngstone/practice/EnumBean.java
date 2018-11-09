package org.youngstone.practice;

import com.fasterxml.jackson.annotation.JsonValue;

public class EnumBean {


    public enum TypeEnumWithValue{
        TYPE1(1, "Type A"), TYPE2(2, "Type 2");

        private Integer id;
        private String name;

        TypeEnumWithValue(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        @JsonValue
        public String getName() {
            return name;
        }
    }
}
