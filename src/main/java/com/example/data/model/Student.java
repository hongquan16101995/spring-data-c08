package com.example.data.model;

import javax.persistence.*;
import javax.validation.constraints.*;

// đánh dấu đây là 1 entity (thực thể), được quản lý bới EntityManager
@Entity
// đổi tên bảng trong Db với @Table, nếu không bảng sẽ mặc định có tên như Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @Max(value = 60)
    @Min(value = 18)
    private Long age;

    private String gender;
    private String address;

    //annotation quy định về mối quan hệ giữa 2 thực thể
    @ManyToOne
    @JoinColumn(name = "c_id")
    private Classroom classroom;

    public Student() {
    }

    public Student(Long id, String name, Long age, String gender, String address, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.classroom = classroom;
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
