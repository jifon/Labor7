package com.example.demo.service;

import com.example.demo.model.Staff;
import com.example.demo.repository.StaffRep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRep staffRep;

    @Override
    public void creatStaff(Staff staff) {
        staffRep.save(staff);
    }


    @Override
    public List<Staff> staffList(){
        return staffRep.findAll();
    }

    @Override
    public Staff findById(Long id) {
        return staffRep.findById(id).get();
    }

    @Override
    public void deletePost(Long id) {
        staffRep.deleteById(id);
    }


}
