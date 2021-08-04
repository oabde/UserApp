package com.ao.usersmanagement.dto;

import com.ao.usersmanagement.utils.Gender;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

   private  Long idUser;

   private  String name;

   private LocalDate birth;

   private String country;

   private Gender gender;

   private String phoneNumber;

}