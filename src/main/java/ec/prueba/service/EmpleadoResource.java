package ec.prueba.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.prueba.model.Departamento;
import ec.prueba.model.Empleado;
import ec.prueba.repository.DepartamentoRepository;
import ec.prueba.repository.EmpleadoRepository;

@Path("api/empleado")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class EmpleadoResource {

    @Inject
    EmpleadoRepository empleadoRepository;
    @Inject
    DepartamentoRepository departRepository;

    @GET
    @Transactional
    public List<Empleado> list() {
        return empleadoRepository.listAll();
    }

    @POST
    @Transactional
    public Response create(Empleado empleado) {
        if (empleado.getCempelado() != null) {
            throw new WebApplicationException("Error al Crear", 422);
        }
        if (empleado.getIdDepartamento() < 0) {
            throw new WebApplicationException("Defina el id del departamento", 422);
        }
        Departamento depar = departRepository.findById(empleado.getIdDepartamento());
        if (depar == null) {
            throw new WebApplicationException("No existe Departamento para asignar al empleado", 422);
        }
        empleado.setCdepartamento(depar);
        empleadoRepository.persist(empleado);
        return Response.ok(empleado).status(201).build();
    }

    @PUT
    @Path("{cempleado}")
    @Transactional
    public Empleado update(@PathParam("cempleado") Long cempleado, Empleado empleado) {

        Empleado entity = empleadoRepository.findById(cempleado);
        if (entity == null) {
            throw new WebApplicationException("empleado con el id" + cempleado + "  no existe", 404);
        }
        entity.setApellido(empleado.getApellido());
        entity.setEdad(empleado.getEdad());
        entity.setNombre(empleado.getNombre());
        empleadoRepository.getEntityManager().merge(entity);
        return entity;
    }

    @DELETE
    @Path("{cempleado}")
    @Transactional
    public Response delete(@PathParam("cempleado") Long cempleado) {
        Empleado entity = empleadoRepository.findById(cempleado);
        if (entity == null) {
            throw new WebApplicationException("empleado con el id" + cempleado + "  no existe", 404);
        }
        empleadoRepository.delete(entity);
        return Response.status(204).build();
    }

}