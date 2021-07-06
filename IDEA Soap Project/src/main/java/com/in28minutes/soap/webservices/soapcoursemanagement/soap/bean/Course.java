package com.in28minutes.soap.webservices.soapcoursemanagement.soap.bean;

public class Course {
    private int id;
    private String name;
    private String desc;
    public Course(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return String.format("Course{id=%d, name='%s', desc='%s'}", id, name, desc);
    }
}

