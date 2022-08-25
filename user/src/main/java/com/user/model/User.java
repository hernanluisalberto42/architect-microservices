package com.user.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "user",uniqueConstraints = @UniqueConstraint(
        name = "email",
        columnNames = "email"
))
public class User implements Serializable {

    private static final Long serialVersionUID=1L;

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "id_user")
    private Long idUser;

    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    @NotNull
    @Column(name = "department_id")
    private Long departmentId;

}
