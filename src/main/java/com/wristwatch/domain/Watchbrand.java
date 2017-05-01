package com.wristwatch.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.OneToMany;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by web on 24/04/17.
 */
@Entity
public class Watchbrand extends AbstractPersistable<Long> {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty
    String brandname;

    @OneToMany(targetEntity = WatchbrandModel.class, mappedBy = "watchbrand", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WatchbrandModel> watchbrandModels;

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

}
