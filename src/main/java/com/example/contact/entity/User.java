package com.example.contact.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user")
@RequiredArgsConstructor
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 1, max = 30, message = "Name should be greater than 1 and less than 30 character")
    @NotNull
    @JsonProperty("name")
    private String name;

    @Size(min = 10, max = 10, message = "Phone No should be equal to 10 character")
    @NotNull
    @JsonProperty("phone_no")
    private String phoneNo;

    @Size(min = 1, max = 30, message = "Email should be greater than 1 and less than 30 character")
    @NotNull
    @JsonProperty("email_id")
    private String emailId;

    @JsonProperty("image")
    private String image;

    @JsonProperty("contacts")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("user")
    @ToString.Exclude
    private Set<Contact> contacts;
}
