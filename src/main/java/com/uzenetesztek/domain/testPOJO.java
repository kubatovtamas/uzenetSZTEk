package com.uzenetesztek.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Data // lombok generates boilerplate code, see Structure tab for details
@AllArgsConstructor // lombok creates a constructor with all fields as args
public class testPOJO {

    @GeneratedValue
    @Id
    private long id;

    private String name;
    private String email;
    private Date dob;
    private boolean spaceCat;

    public testPOJO() { }


}
