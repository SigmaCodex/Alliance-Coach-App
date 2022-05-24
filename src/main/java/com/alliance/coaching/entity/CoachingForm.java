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
 * @created May 19, 2022 9:15 PM
 */

@Entity
@Table(name = "coaching_form")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoachingForm {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "form_id")
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", columnDefinition = "BIGINT NOT NULL")
    private Employee supervisor;

    @Column(name = "team_member", columnDefinition = "VARCHAR (100) NOT NULL")
    private String teamMember;

    @Column(name = "role_position", columnDefinition = "VARCHAR (100) NOT NULL")
    private String rolePosition;

    @Column(name = "topic_area", columnDefinition = "VARCHAR (255) NOT NULL")
    private String topicArea;

    @Column(name = "desired_outcome", columnDefinition = "VARCHAR (255) NOT NULL")
    private String desiredOutcome;

    @Column(name = "benefit", columnDefinition = "VARCHAR (255) NOT NULL")
    private String benefit;

    @Column(name = "timeline", columnDefinition = "VARCHAR (255) NOT NULL")
    private String timeline;

    @Column(name = "attached_file", columnDefinition = "VARCHAR (255) NOT NULL")
    private String attachedFile;

    @Column(name = "created_at", columnDefinition = "DATE NOT NULL")
    private String createdAt;

    @Transient
    public String getAttachedFile() {
        if (attachedFile == null)
            return null;
        return "/form-file/" + id + "/" + attachedFile;
    }

}
