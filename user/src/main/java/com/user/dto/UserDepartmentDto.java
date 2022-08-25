package com.user.dto;

import com.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDepartmentDto {

    private User user;
    private DepartmentDto departmentDto;
}
