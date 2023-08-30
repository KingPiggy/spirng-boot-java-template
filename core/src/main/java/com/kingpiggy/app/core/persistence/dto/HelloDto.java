package com.kingpiggy.app.core.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HelloDto {

    private Long id;
    private String title;
    private String description;

}
