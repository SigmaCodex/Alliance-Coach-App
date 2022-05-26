package com.alliance.coaching.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project Alliance-Coach-App
 * @created May 19, 2022 9:41 PM
 */

@Entity
@Table(name = "action")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "action_id")
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "form_id", referencedColumnName = "form_id", columnDefinition = "BIGINT NOT NULL")
    private CoachingForm form;

    @Column(name = "action_plan", columnDefinition = "VARCHAR (255) NOT NULL")
    private String actionPlan;

    @Column(name = "status", columnDefinition = "INT DEFAULT '0' NOT NULL")
    private int status = 0;

    @Column(name = "last_modified", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public Timestamp lastModified = new Timestamp(System.currentTimeMillis());

}
