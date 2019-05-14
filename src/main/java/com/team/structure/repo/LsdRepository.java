package com.team.structure.repo;

import com.team.structure.domain.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LsdRepository extends JpaRepository<TeamMember, Long> {

}
