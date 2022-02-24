package com.Project.Roommate.Entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="user")
@AllArgsConstructor
@Builder
@Setter
@Entity
public class User {

    @Id
    @Column(length = 20, nullable = false,unique = true)
    private String userid;
    @Column(length = 100, nullable = false)
    private String userpw;
    @Column(length = 30)
    private String userpn;
    @Column(length = 30)
    private String useremail;


    @CreationTimestamp
    private Timestamp createDate;
}
