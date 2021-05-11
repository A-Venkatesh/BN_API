package com.konda.baskinnature.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("site")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Site {
    @Id
    private String id = "BASK_IN_NATURE";

    private String aboutus;

    private String returnPolicy;
    private String privacyPolicy;

    private String termsAndConditions;

    private String username = "root";
    private String password = "password";
}
