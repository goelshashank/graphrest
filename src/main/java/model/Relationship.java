package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by shashank on 28/5/16.
 */

@Entity
@Table(name = "relationships")
public class Relationship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "edgeid")
    private Long edgeid;

    @Column(name = "fromuserid")
    private Long fromuserid;

    @Column(name = "touserid")
    private Long touserid;

    @Column(name="relation")
    private String relation;

    public Relationship() {
    }

    public Relationship(Long fromuserid, Long touserid, String relation) {
        this.fromuserid = fromuserid;
        this.touserid = touserid;
        this.relation = relation;
    }

    public Long getEdgeid() {
        return edgeid;
    }

    public void setEdgeid(Long edgeid) {
        this.edgeid = edgeid;
    }

    public Long getFromuserid() {
        return fromuserid;
    }

    public void setFromuserid(Long fromuserid) {
        this.fromuserid = fromuserid;
    }

    public Long getTouserid() {
        return touserid;
    }

    public void setTouserid(Long touserid) {
        this.touserid = touserid;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }




}
