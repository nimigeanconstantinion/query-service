package com.example.service1.service;

import com.example.service1.model.MapStocOptim;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MapStocOptService {

    List<MapStocOptim> getAllMapStocOpt();

    MapStocOptim getMapStocOptByID(String id);

}
