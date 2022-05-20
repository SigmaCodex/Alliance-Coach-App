package com.alliance.coaching.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project Alliance-Coach-App
 * @created May 19, 2022 9:34 PM
 */

@Entity
@Table(name = "desired_outcome")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesiredOutcome {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "outcome_id")
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "form_id", referencedColumnName = "form_id", columnDefinition = "BIGINT NOT NULL")
    private CoachingForm form;

    @Column(name = "desired_outcome", columnDefinition = "VARCHAR (255) NOT NULL")
    private String desiredOutcome;

}
