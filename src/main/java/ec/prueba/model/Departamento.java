package ec.prueba.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Departamento extends PanacheEntityBase {

    private static final long serialVersionUID = 1L;
    @Column(name = "nombre")
    private String nombre;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "cdepartamento")
    private Long cdepartamento;
    @OneToMany(mappedBy = "cdepartamento")
    private Collection<Empleado> empleadoCollection;
    @JoinColumn(name = "ccategoria", referencedColumnName = "ccategoria")
    @ManyToOne
    private Categoria ccategoria;

    public Departamento() {
    }

    public Departamento(Long cdepartamento) {
        this.cdepartamento = cdepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCdepartamento() {
        return cdepartamento;
    }

    public void setCdepartamento(Long cdepartamento) {
        this.cdepartamento = cdepartamento;
    }


    @JsonIgnore
    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }


    @JsonIgnore
    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @JsonIgnore
    public Categoria getCcategoria() {
        return ccategoria;
    }

    @JsonIgnore
    public void setCcategoria(Categoria ccategoria) {
        this.ccategoria = ccategoria;
    }

}
