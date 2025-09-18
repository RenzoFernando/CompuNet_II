package edu.co.icesi.examjpatemplate.repository;

import edu.co.icesi.examjpatemplate.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository <Route, Integer> {

    //nanai aqui he


}
