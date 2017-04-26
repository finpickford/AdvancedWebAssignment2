package com.wristwatch.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by web on 24/04/17.
 */
@Entity
public class Watchbrand {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty
    String brandname;

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
