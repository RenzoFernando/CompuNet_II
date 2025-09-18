package edu.co.icesi.examjpatemplate.repository;

import edu.co.icesi.examjpatemplate.entity.GeoPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeoPointRepository extends JpaRepository<GeoPoint, Integer> {

    //Obtener todos los geopoints
    //geopoints de buses
    //que esos buses atienden una ruta
    //y esa ruta es específica.
    //
    //Por ejemplo, obtener todos los geopoints de buses que atienden la ruta T31
    List<GeoPoint> findByBus_Route_RouteName(String routeName);


    //Obtener la ubicación
    //una ubicacion es un geopoint
    //encontrar el más reciente
    //el mas reciente registrado
    //registrado de un bus
    //de bus según su matrícula
    //
    //Por ejemplo del bus EEE555 donde estuvo la ultima vez
    Optional<GeoPoint> findFirstByBus_LicensePlateOrderByTimestampDesc(String licensePlate);
}
