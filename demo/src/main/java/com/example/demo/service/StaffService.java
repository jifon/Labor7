package com.example.demo.service;

import com.example.demo.model.Staff;

import java.util.List;

public interface StaffService {
    public void creatStaff(Staff staff);
    public List<Staff> staffList();
    public Staff findById(Long id);
    public void deletePost(Long id);
}
