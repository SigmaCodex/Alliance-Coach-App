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
 * @created Mar 26, 2022 2:57 PM
 */

@Entity
@Table(name = "timeline")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Timeline {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    @Column(name = "timeline_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coaching_form_id", referencedColumnName = "coaching_form_id")
    private CoachingForm coachingForm;

    @Column(name = "note", columnDefinition = "VARCHAR(255)")
    private String note;

    @Column(name = "date", columnDefinition = "DATETIME")
    private Date date;
}
