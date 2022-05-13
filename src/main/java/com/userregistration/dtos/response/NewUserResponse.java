package com.userregistration.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.userregistration.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewUserResponse {

    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime modified;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonProperty("last_login")
    private LocalDateTime lastLogin;

    private String token;

    private Boolean isActive;

    public NewUserResponse toResponse(User user){

        return NewUserResponse.builder()
                .id(user.getUuid().toString())
                .created(user.getCreated())
                .modified(user.getModified())
                .lastLogin(user.getLastLogin())
                .token(user.getToken())
                .isActive(user.getIsActive())
                .build();
    }
}
