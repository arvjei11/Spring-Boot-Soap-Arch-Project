package com.in28minutes.soap.webservices.soapcoursemanagement.soap.service;

import com.in28minutes.courses.Status;
import com.in28minutes.soap.webservices.soapcoursemanagement.soap.bean.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseDetailsService {
    public enum status{
        SUCCESS,FAILURE;
    }
    private static List<Course> courses = new ArrayList<>();

    static {

        Course course1 = new Course(1, "Spring Framework", "A guide to Spring Framework");
        courses.add(course1);
        Course course2 = new Course(2, "Spring Boot", "A guide to the spring boot system");
        courses.add(course2);

        Course course3 = new Course(3, "Spring MVC", "A guide to the Spring MVC feature");
        courses.add(course3);

        Course course4 = new Course(4, "JAXB", "Its buggy on Eclipse");
        courses.add(course4);

        Course course5 = new Course(5, "Wizdlr", "An extension to handle soap requests");
        courses.add(course5);

    }

    public Course findByID(int id) {
        for (Course course : courses) {
            if (course.getId() == id)
                return course;
        }
        return null;
    }

    public List<Course> findAll() {
        return courses;
    }

    public Status deleteByID(int id) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();

            if (course.getId() == id) {
                iterator.remove();
                return Status.SUCCEED;
            }
        }
        return Status.FAILURE;
    }


}