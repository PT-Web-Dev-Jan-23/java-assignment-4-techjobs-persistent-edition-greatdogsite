package org.launchcode.techjobs.persistent.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity{ // --done part 3b. extend AbstractEntity and dry code

    @ManyToOne   //set up many-to-one relationship with employer
    private Employer employer;

    @ManyToMany //--done part 4. update Job class to support many-to-many relationship with Skills
    private final List<Skill> skills = new ArrayList<>();

    public Job() {
    }

    public Job(Employer anEmployer, List<Skill> someSkills) {
        super();
        this.employer = anEmployer;
        for(Skill skill: someSkills){
            this.skills.add(skill);
        }
    }

    // Getters and setters.

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

//    public void setSkills(String skills) {
//        this.skills = skills;
//    }

    public void setSkills(List<Skill> skills){
        for(Skill skill: skills){
            this.skills.add(skill);
        }
    }
}
