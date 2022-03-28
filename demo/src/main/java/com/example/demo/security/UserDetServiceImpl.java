package com.example.demo.security;

import com.example.demo.model.Staff;
import com.example.demo.repository.StaffRep;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserDetServiceImpl implements UserDetailsService {
    private final StaffRep staffRep;
    @Override
    public UserDetails loadUserByUsername(String pNummer) throws UsernameNotFoundException {
        Staff staff = staffRep.findByPassportNumber(pNummer);
        UserDetImpl userDetImpl = new UserDetImpl(staff);
        return userDetImpl;
    }
}
