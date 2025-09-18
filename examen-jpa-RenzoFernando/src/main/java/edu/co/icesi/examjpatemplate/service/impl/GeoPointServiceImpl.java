// src/main/java/edu/co/icesi/examjpatemplate/service/impl/GeoPointServiceImpl.java
package edu.co.icesi.examjpatemplate.service.impl;

import edu.co.icesi.examjpatemplate.entity.GeoPoint;
import edu.co.icesi.examjpatemplate.repository.GeoPointRepository;
import edu.co.icesi.examjpatemplate.service.GeoPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeoPointServiceImpl implements GeoPointService {

    @Autowired
    private GeoPointRepository geoPointRepository;

    //Obtener todos los geopoints
    //geopoints de buses
    //que esos buses atienden una ruta
    //y esa ruta es específica.
    //
    //Por ejemplo, obtener todos los geopoints de buses que atienden la ruta T31
    @Override
    public List<GeoPoint> findByBus_Route_RouteName(String route) {
        return geoPointRepository.findByBus_Route_RouteName(route);
    }

    //Obtener la ubicación
    //una ubicacion es un geopoint
    //encontrar el más reciente
    //el mas reciente registrado
    //registrado de un bus
    //de bus según su matrícula
    //
     //Por ejemplo del bus EEE555 donde estuvo la ultima vez
    @Override
    public Optional<GeoPoint> findFirstByBus_LicensePlateOrderByTimestampDesc(String licensePlate) {
        return geoPointRepository.findFirstByBus_LicensePlateOrderByTimestampDesc(licensePlate);
    }


}
