package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "staff")
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "passport_nummer", unique = true)
    private String passportNummer;

    private String address;

    @Column(length = 1000)
    private String password;

    private String role;

    private int  active;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;

    @Override
    public String toString() {
        return "User [fullName=" + fullName + ", address=" + address + ", personalNummer=" + passportNummer + ", password=" + password
                + ", role=" + role + "]";
    }

    public List<String> getRoleList() {
        if (this.role.length() > 0) {
            return Arrays.asList(this.role.split(","));
        }

        return new ArrayList<String>();
    }

    public int getActive() {
        return active;
    }




}
