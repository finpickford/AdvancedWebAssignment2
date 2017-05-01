package com.wristwatch.domain;

import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;

/**
 * Created by web on 26/04/17.
 */
@Entity
public class WatchbrandModel extends AbstractPersistable<Long> {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty
    String modelname;

    @NotEmpty
    String modelno;

    @NotEmpty
    String description;

    private transient Long watchbrandId;

    @ManyToOne
    @JoinColumn(name = "watchbrand_id")
    private Watchbrand watchbrand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getModelno() {
        return modelno;
    }

    public void setModelno(String modelno) {
        this.modelno = modelno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getBrandID() {
        return watchbrandId;
    }

    public void setBrandId(Long brandId) {
        this.watchbrandId = watchbrandId;
    }

    public Watchbrand getWatchbrand(){
        return watchbrand;
    }

    public void setWatchbrand(Watchbrand watchbrand) {
        this.watchbrand = watchbrand;
    }
}
