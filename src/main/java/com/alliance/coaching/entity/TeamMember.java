package com.alliance.coaching.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 3:00 PM
 */

@Entity
@Table(name = "team_member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class TeamMember extends Employee {

    @ManyToOne
    @JoinColumn(name = "coaching_form_id", referencedColumnName = "coaching_form_id")
    private CoachingForm coachingForm;

    @Column(name = "role_position", columnDefinition = "VARCHAR(255)")
    private String rolePosition;

}
