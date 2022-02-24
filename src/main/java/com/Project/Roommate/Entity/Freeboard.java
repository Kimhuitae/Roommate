package com.Project.Roommate.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="freeboard")
@AllArgsConstructor
@Builder
@Entity
public class Freeboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fbn;

    @Column(length = 50,nullable = false)
    private String fbo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userid")
    private User user;

    @CreationTimestamp
    private Timestamp fbd;

    @Lob
    private String fbrcontent;

    @OneToMany(mappedBy = "freeboard", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"freeboard"})
    @OrderBy("fbn desc")
    private List<Freeboardreply> reply;

    private int fbavaliabel;
}
