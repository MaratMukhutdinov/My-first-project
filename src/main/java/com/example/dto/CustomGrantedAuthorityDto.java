package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Модель для роли.
 */
@EqualsAndHashCode
@AllArgsConstructor
public class CustomGrantedAuthorityDto implements GrantedAuthority, Serializable {

    /**
     * Наименование роли.
     */
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

}