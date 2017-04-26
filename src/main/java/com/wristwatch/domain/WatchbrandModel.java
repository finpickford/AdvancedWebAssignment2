package com.wristwatch.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by web on 26/04/17.
 */
@Entity
public class WatchbrandModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long brand_id;

    @NotEmpty
    String modelname;

    @NotEmpty
    String modelno;

    @NotEmpty
    String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
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

}
