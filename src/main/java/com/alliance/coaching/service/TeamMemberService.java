package com.alliance.coaching.service;

import com.alliance.coaching.entity.TeamMember;
import com.alliance.coaching.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rieugene Basilisco (generieu17@gmail.com)
 * @project coaching
 * @created Mar 26, 2022 3:11 PM
 */

@Service
@RequiredArgsConstructor
public class TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;

    // TODO: 3/26/2022 create new team member
    public TeamMember create(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }

    // TODO: 3/26/2022 get team member by id
    public TeamMember getById(Long id) {
        if (teamMemberRepository.findById(id).isPresent()) {
            return teamMemberRepository.findById(id).get();
        }
        throw new IllegalStateException("Team member not found");
    }

    // TODO: 3/26/2022 get all team member by coaching form id
    public List<TeamMember> getAllByCoachingFormId(Long id) {
        return teamMemberRepository.findAllByCoachingFormId(id);
    }

    // TODO: 3/26/2022 get all team member, this may be for HR only
    public List<TeamMember> getAll() {
        return teamMemberRepository.findAll();
    }

    // TODO: 3/28/2022 login employee
    public TeamMember loginEmployee(String username, String password) {
        TeamMember teamMember = teamMemberRepository.findByUsernameAndPassword(username, password);
        if (teamMemberRepository.existsById(teamMember.getId())) {
            return teamMember;
        }
        throw new IllegalStateException("Employee not found");
    }

    // TODO: 3/26/2022 update team member
    public void update(Long id, TeamMember teamMember) {
        TeamMember currentTeamMember = teamMemberRepository
                .findById(id)
                .orElseThrow(() -> new IllegalStateException("Team member not found"));
        // TODO: 3/26/2022 validate new team member content
        // this is to set new data to old team member
        currentTeamMember.setFirstName(teamMember.getFirstName());
        currentTeamMember.setLastName(teamMember.getLastName());
        currentTeamMember.setContactNo(teamMember.getContactNo());
        currentTeamMember.setRolePosition(teamMember.getRolePosition());
        currentTeamMember.setEmployeeType(teamMember.getEmployeeType());
        teamMemberRepository.save(currentTeamMember);
    }

    // TODO: 3/26/2022 delete team member
    public void delete(Long id) {
        teamMemberRepository.deleteById(id);
    }

}
