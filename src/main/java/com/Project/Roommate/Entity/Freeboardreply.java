package com.Project.Roommate.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="freeboardreply")
@AllArgsConstructor
@Builder
@Setter
@Entity
public class Freeboardreply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int replyid;

    @Column(nullable = false,length = 30)
    private String replycontent;

    @ManyToOne
    @JoinColumn(name="fbn")
    private Freeboard freeboard;

    @ManyToOne
    @JoinColumn(name="userid")
    private User user;

}
