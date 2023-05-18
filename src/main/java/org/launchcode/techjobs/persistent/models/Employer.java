package org.launchcode.techjobs.persistent.models;


import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//--done 2a. todo: add location with validation, getters and setters, add entity, and constructors.
@Entity
public class Employer extends AbstractEntity {

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
}
