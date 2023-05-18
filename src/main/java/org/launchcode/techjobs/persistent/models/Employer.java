package org.launchcode.techjobs.persistent.models;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//--done 2a. todo: add location with validation, getters and setters, add entity, and constructors.
@Entity
public class Employer extends AbstractEntity {

//    @JoinColumn(name = "employer_id")
    @OneToMany(mappedBy = "employer")
    private final List<Job> jobs = new ArrayList<>(); //--done 3a. add one-to-many relationship

    @NotBlank
    @NotNull
    @Size(min=3, max= 255, message="Please enter a location.")
    private String location;

    public Employer(String location) {
        this.location = location;
    }

    public Employer(){} // no arg constructor for model binding and hibernate

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

}
