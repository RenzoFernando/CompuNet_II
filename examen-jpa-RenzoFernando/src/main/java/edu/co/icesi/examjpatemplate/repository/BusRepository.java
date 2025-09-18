package edu.co.icesi.examjpatemplate.repository;

import edu.co.icesi.examjpatemplate.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository <Bus, Integer> {

    //Encontrar los buses
    //buses que atienden rutas
    //rutas de un tipo particular.
    //
    //Por ejemplo, obtener los buses que atienden rutas tipo Alimentador
    List<Bus> findBusByRoute_Type(String routeType);
}
