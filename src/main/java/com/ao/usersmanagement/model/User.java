package com.ao.usersmanagement.model;

import com.ao.usersmanagement.utils.Gender;
import com.ao.usersmanagement.validator.ValidPhoneNumber;
import lombok.*;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@Table(name = "T_USER")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "name_user")
    @NotNull(message = "Name is mandatory")
    private String name;

    @Column(name = "birth")
    @NotNull(message = "birthDay is mandatory")
    private LocalDate birth;

    @Column(name = "country")
    @NotNull(message = "country is mandatory")
    private String country;


    @Column(name = "gender")
    private Gender gender;

    @Column(name="phone_number")
    @ValidPhoneNumber(message="Please enter a valid phone number")
    private String phoneNumber;


}
