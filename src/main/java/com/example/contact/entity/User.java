package com.example.contact.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

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

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone_no")
    private String phoneNo;

    @JsonProperty("email_id")
    private String emailId;

    @JsonProperty("image")
    private String image;
}
