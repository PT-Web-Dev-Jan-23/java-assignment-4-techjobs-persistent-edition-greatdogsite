package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// --done 2c. todo: create data layer interface, add respository, import crudrepository
@Repository
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
}
