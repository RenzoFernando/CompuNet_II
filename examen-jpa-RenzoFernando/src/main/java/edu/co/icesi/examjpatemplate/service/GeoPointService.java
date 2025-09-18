package edu.co.icesi.examjpatemplate.service;

import edu.co.icesi.examjpatemplate.entity.GeoPoint;

import java.util.List;
import java.util.Optional;

public interface GeoPointService {

    List<GeoPoint> findByBus_Route_RouteName(String route);

    Optional<GeoPoint> findFirstByBus_LicensePlateOrderByTimestampDesc(String licensePlate);


}
