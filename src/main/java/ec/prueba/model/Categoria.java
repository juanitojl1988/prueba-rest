package ec.prueba.model;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
@Entity
public class Categoria extends PanacheEntityBase {
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ccategoria")
    private Long ccategoria;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "ccategoria")
    private Collection<Departamento> departamentoCollection;

    public Categoria() {
    }

    public Categoria(Long ccategoria) {
        this.ccategoria = ccategoria;
    }

    public Long getCcategoria() {
        return ccategoria;
    }

    public void setCcategoria(Long ccategoria) {
        this.ccategoria = ccategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Departamento> getDepartamentoCollection() {
        return departamentoCollection;
    }

    public void setDepartamentoCollection(Collection<Departamento> departamentoCollection) {
        this.departamentoCollection = departamentoCollection;
    }
}
