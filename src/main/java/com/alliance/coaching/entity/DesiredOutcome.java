package com.alliance.coaching.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 2:55 PM
 */

@Entity
@Table(name = "desired_outcome")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesiredOutcome {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "desired_outcome_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coaching_form_id", referencedColumnName = "coaching_form_id")
    private CoachingForm coachingForm;

    @Column(name = "desired_outcome", columnDefinition = "VARCHAR(255)")
    private String desiredOutcome;
}
