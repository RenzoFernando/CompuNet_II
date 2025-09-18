package edu.co.icesi.examjpatemplate.service.impl;

import edu.co.icesi.examjpatemplate.entity.Bus;
import edu.co.icesi.examjpatemplate.repository.BusRepository;
import edu.co.icesi.examjpatemplate.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    //Encontrar los buses
    //buses que atienden rutas
    //rutas de un tipo particular.
    //
    //Por ejemplo, obtener los buses que atienden rutas tipo Alimentador
    @Override
    public List<Bus> findBusByRoute_Type(String routeType) {
        return busRepository.findBusByRoute_Type(routeType);
    }
}
