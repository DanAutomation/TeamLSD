package com.team.structure.service;

import java.util.List;

import com.team.structure.domain.TeamMember;
import com.team.structure.repo.LsdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LsdService {
    @Autowired
    protected LsdRepository lsdRepository;

    public List<TeamMember> allMembers(){
        return lsdRepository.findAll();
    }

    public void saveMember(TeamMember teamMember){
        lsdRepository.save(teamMember);
    }

    public TeamMember getMember(Long id){
        return lsdRepository.findById(id).get();
    }

    public void delete(long id){
        lsdRepository.deleteById(id);
    }

}
