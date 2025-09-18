package edu.co.icesi.examjpatemplate.service;

import edu.co.icesi.examjpatemplate.entity.Bus;

import java.util.List;

public interface BusService {

    List<Bus> findBusByRoute_Type(String routeType);
}
