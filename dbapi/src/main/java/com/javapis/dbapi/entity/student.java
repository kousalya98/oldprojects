package com.javapis.dbapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class student {

    @Column(name = "student_Name")
    public String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int rollNo;
    @Column(name = "student_Branch")
    public String branch;

    public student() {
    }

    public student(String branch, String name) {
        this.branch = branch;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("student{");
        sb.append("Name=").append(name);
        sb.append(", RollNo=").append(rollNo);
        sb.append(", Branch=").append(branch);
        sb.append('}');
        return sb.toString();
    }
}
