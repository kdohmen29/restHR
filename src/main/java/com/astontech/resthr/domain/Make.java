package com.astontech.resthr.domain;

import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String makeName;

//    @Fetch(FetchMode.SELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Model> modelList;

    public Make(String makeName) {
        this.makeName = makeName;
    }

    public Make() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    public List<Model> getModelList() {
        return modelList;
    }

    public void setModelList(List<Model> modelList) {
        this.modelList = modelList;
    }
}