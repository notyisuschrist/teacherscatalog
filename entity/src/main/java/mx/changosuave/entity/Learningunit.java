/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.changosuave.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author J_K1483
 */
@Entity
@Table(name = "learningunit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Learningunit.findAll", query = "SELECT l FROM Learningunit l")
    , @NamedQuery(name = "Learningunit.findByIdLearningUnit", query = "SELECT l FROM Learningunit l WHERE l.idLearningUnit = :idLearningUnit")
    , @NamedQuery(name = "Learningunit.findByName", query = "SELECT l FROM Learningunit l WHERE l.name = :name")
    , @NamedQuery(name = "Learningunit.findByClassHours", query = "SELECT l FROM Learningunit l WHERE l.classHours = :classHours")
    , @NamedQuery(name = "Learningunit.findByWorkshopHours", query = "SELECT l FROM Learningunit l WHERE l.workshopHours = :workshopHours")
    , @NamedQuery(name = "Learningunit.findByLaboratoryHours", query = "SELECT l FROM Learningunit l WHERE l.laboratoryHours = :laboratoryHours")})
public class Learningunit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLearningUnit")
    private Integer idLearningUnit;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "classHours")
    private int classHours;
    @Basic(optional = false)
    @Column(name = "workshopHours")
    private int workshopHours;
    @Basic(optional = false)
    @Column(name = "laboratoryHours")
    private int laboratoryHours;
    @JoinTable(name = "teacher_learningunit", joinColumns = {
        @JoinColumn(name = "idLearningUnit", referencedColumnName = "idLearningUnit")}, inverseJoinColumns = {
        @JoinColumn(name = "idTeacher", referencedColumnName = "idTeacher")})
    @ManyToMany(mappedBy = "learningunitList")
    private List<Teacher> teacherList;

    public Learningunit() {
    }

    public Learningunit(Integer idLearningUnit) {
        this.idLearningUnit = idLearningUnit;
    }

    public Learningunit(Integer idLearningUnit, String name, int classHours, int workshopHours, int laboratoryHours) {
        this.idLearningUnit = idLearningUnit;
        this.name = name;
        this.classHours = classHours;
        this.workshopHours = workshopHours;
        this.laboratoryHours = laboratoryHours;
    }

    public Integer getIdLearningUnit() {
        return idLearningUnit;
    }

    public void setIdLearningUnit(Integer idLearningUnit) {
        this.idLearningUnit = idLearningUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassHours() {
        return classHours;
    }

    public void setClassHours(int classHours) {
        this.classHours = classHours;
    }

    public int getWorkshopHours() {
        return workshopHours;
    }

    public void setWorkshopHours(int workshopHours) {
        this.workshopHours = workshopHours;
    }

    public int getLaboratoryHours() {
        return laboratoryHours;
    }

    public void setLaboratoryHours(int laboratoryHours) {
        this.laboratoryHours = laboratoryHours;
    }

    @XmlTransient
    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLearningUnit != null ? idLearningUnit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Learningunit)) {
            return false;
        }
        Learningunit other = (Learningunit) object;
        if ((this.idLearningUnit == null && other.idLearningUnit != null) || (this.idLearningUnit != null && !this.idLearningUnit.equals(other.idLearningUnit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.changosuave.entity.Learningunit[ idLearningUnit=" + idLearningUnit + " ]";
    }
    
}
