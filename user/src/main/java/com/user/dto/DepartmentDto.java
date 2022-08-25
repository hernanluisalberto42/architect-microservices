package com.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DepartmentDto implements Serializable {

    private Long idDepartment;
    private String nameDepartment;
    private Integer count;
}
