package edu.co.icesi.examjpatemplate.controller;

import edu.co.icesi.examjpatemplate.entity.Bus;
import edu.co.icesi.examjpatemplate.entity.GeoPoint;
import edu.co.icesi.examjpatemplate.service.BusService;
import edu.co.icesi.examjpatemplate.service.GeoPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ParcialController {

    @Autowired
    private BusService busService;

    @Autowired
    private GeoPointService geoPointService;

    @GetMapping("/q1")
    public ResponseEntity<?> q1(){
        List<Bus> b = busService.findBusByRoute_Type("Alimentador");
        return ResponseEntity.status(200).body(b);
    }

    @GetMapping("/q2")
    public ResponseEntity<?> q2(){
        List<GeoPoint> g = geoPointService.findByBus_Route_RouteName("T31");
        return ResponseEntity.status(200).body(g);
    }

    @GetMapping("/q3")
    public ResponseEntity<?> q3(){
        Optional<GeoPoint> g = geoPointService.findFirstByBus_LicensePlateOrderByTimestampDesc("EEE555");
        return ResponseEntity.status(200).body(g);
    }

}
