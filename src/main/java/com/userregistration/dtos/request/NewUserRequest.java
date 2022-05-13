package com.userregistration.dtos.request;

import com.userregistration.entities.Phone;
import com.userregistration.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserRequest {

    @NotBlank(message = "Name may not be empty")
    private String name;

    private String email;
    private String password;
    private List<NewUserPhonesRequest> phones;

    public User toEntity(){

        List<Phone> phoneList = this.getPhones().stream()
                .map(phone-> Phone.builder()
                        .number(phone.getNumber())
                        .cityCode(phone.getCityCode())
                        .countryCode(phone.getCountryCode())
                        .build())
                .collect(Collectors.toList());

        User user = User.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .created(LocalDate.now())
                .modified(LocalDateTime.now())
                .lastLogin(LocalDateTime.now())
                .isActive(true)
                .phones(phoneList)
                .build();

        user.getPhones().forEach(phone ->  phone.setUser(user));

        return user;
    }

}
