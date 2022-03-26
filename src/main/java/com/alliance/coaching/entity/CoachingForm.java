package com.alliance.coaching.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 2:50 PM
 */

@Entity
@Table(name = "coaching_form")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoachingForm {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "coaching_form_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coach_id", referencedColumnName = "user_id")
    private Employee coach;

    @Column(name = "topic_area", columnDefinition = "VARCHAR(255)")
    private String topicArea;

    @Column(name = "benefit", columnDefinition = "VARCHAR(255)")
    private String benefit;

    @Column(name = "created_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt = new Date();
}
