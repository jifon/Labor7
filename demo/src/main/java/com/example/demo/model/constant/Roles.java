package com.example.demo.model.constant;

import org.springframework.security.core.GrantedAuthority;

public enum Roles  implements GrantedAuthority{
    Deputy_Director, Former, Sale_Manager
    ;

    @Override
    public String getAuthority() {
        return name();
    }
}
