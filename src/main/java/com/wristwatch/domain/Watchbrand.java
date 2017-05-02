package com.wristwatch.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.OneToMany;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by web on 24/04/17.
 */

// Create a table to store all of the brands.
@Entity
public class Watchbrand {

    Long id;

    @NotEmpty
    String brandname;

    private Set<WatchbrandModel> watchbrandModels;

    public Watchbrand() {

    }

    public Watchbrand(String brandname) {
        this.brandname = brandname;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    // Link the one to many relationship, and map it using the watchbrand instance. Cascade each model with deletion of the brand.
    @OneToMany(mappedBy = "watchbrand", cascade = CascadeType.ALL)
    public Set<WatchbrandModel> getWatchbrandModels() {
        return watchbrandModels;
    } // Set the watchbrand model as a set type.

    public void setWatchbrandModels(Set<WatchbrandModel> watchbrandModels) {
        this.watchbrandModels = watchbrandModels;
    }

}
