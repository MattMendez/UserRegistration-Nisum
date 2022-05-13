package com.userregistration.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Phone {

    @Id
    private String number;

    private String cityCode;

    private String countryCode;

    @ManyToOne()
    @JoinColumn(name = "user_uuid",
            referencedColumnName = "uuid")
    @ToString.Exclude
    private User user;
}
