package com.wristwatch.domain;

import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by web on 26/04/17.
 */
@Entity
public class WatchbrandModel {

    Long id;

    @NotEmpty
    String modelname;

    @NotEmpty
    String modelno;

    @NotEmpty
    String description;

    @NotEmpty
    String casesize;

    @NotEmpty
    String dialcolour;

    @NotEmpty
    String movement;

    @NotEmpty
    String price;

    private Watchbrand watchbrand;

    public WatchbrandModel() {

    }

    public WatchbrandModel(String modelname){
        this.modelname = modelname;
    }

    public WatchbrandModel(String modelname, Watchbrand watchbrand){
        this.modelname = modelname;
        this.watchbrand = watchbrand;
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getCasesize() {
        return casesize;
    }

    public void setCasesize(String casesize) {
        this.casesize = casesize;
    }

    public String getDialcolour() {
        return dialcolour;
    }

    public void setDialcolour(String dialcolour) {
        this.dialcolour = dialcolour;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "watchbrand_id")
    public Watchbrand getWatchbrand() {
        return watchbrand;
    }

    public void setWatchbrand(Watchbrand watchbrand) {
        this.watchbrand = watchbrand;
    }

}
