package com.example.wwmd.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`city`")
public class City extends BaseEntity implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`state`")
    private String state;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }
}