package com.st.Demo.model;


import javax.persistence.*;

@Entity
@Table
public class Student {

    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Id
    private Long id;
    private String name;
    private String schoolName;
    private String email;


    public Student() {
    }

    public Student(String name, String schoolName, String email) {
        this.name = name;
        this.schoolName = schoolName;
        this.email = email;
    }

    public Student(Long id, String name, String schoolName, String email){
        this.id = id;
        this.name = name;
        this.schoolName = schoolName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
