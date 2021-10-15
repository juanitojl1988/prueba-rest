package ec.prueba.repository;



import javax.enterprise.context.ApplicationScoped;

import ec.prueba.model.Empleado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EmpleadoRepository implements PanacheRepository<Empleado> {

    public Empleado findByName(String nombre) {
        return find("nombre", nombre).firstResult();
    }

 

}
