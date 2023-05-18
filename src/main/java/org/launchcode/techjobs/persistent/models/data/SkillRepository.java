package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// --done 2d. todo: create data layer interface, add respository, import crudrepository
@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
}
