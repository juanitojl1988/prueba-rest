package ec.prueba.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Empleado extends PanacheEntityBase {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "cempelado")
    private Long cempelado;
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "cdepartamento", referencedColumnName = "cdepartamento")
    @ManyToOne
    private Departamento cdepartamento;

    @Transient
    private long idDepartamento;

    public long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Empleado() {
    }

    public Empleado(Long cempelado) {
        this.cempelado = cempelado;
    }

    public Empleado(Long cempelado, int edad) {
        this.cempelado = cempelado;
        this.edad = edad;
    }

    public Long getCempelado() {
        return cempelado;
    }

    public void setCempelado(Long cempelado) {
        this.cempelado = cempelado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonIgnore
    public Departamento getCdepartamento() {
        return cdepartamento;
    }
    @JsonIgnore
    public void setCdepartamento(Departamento cdepartamento) {
        this.cdepartamento = cdepartamento;
    }

}