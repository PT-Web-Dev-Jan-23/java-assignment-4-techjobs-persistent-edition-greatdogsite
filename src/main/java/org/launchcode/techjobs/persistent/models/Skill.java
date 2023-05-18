package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//--done 2b. todo: add description with validation, getters and setters, add entity, and constructors.
@Entity
public class Skill extends AbstractEntity {

    @NotBlank
    @NotNull
    @Size(min=3, max=1000, message="Please enter a description greater than 3 characters and less than 1,000 characters")
    private String description;

    public Skill(String description) {
        this.description = description;
    }

    public Skill(){} //no arg constructor for model binding and hibernate

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}