package com.example.service1.service;

import com.example.service1.model.MapStocOptim;
import com.example.service1.repository.StocOptimRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MapStocOptImplService implements MapStocOptService{

    private StocOptimRepo stocOptimRepo;

    public MapStocOptImplService(StocOptimRepo stocOptimRepo) {
        this.stocOptimRepo = stocOptimRepo;
    }


    @Override
    public List<MapStocOptim> getAllMapStocOpt() {
        List<MapStocOptim> lista=stocOptimRepo.findAll();
        return lista;
    }

    @Override
    public MapStocOptim getMapStocOptByID(String idA) {
        Optional<MapStocOptim> opm= stocOptimRepo.findByIdArticol(idA);
        if(!opm.isPresent()){
            log.error("querySrvFailID: "+idA);
            throw new RuntimeException("ID-ul nu exista!!");
        }
        return opm.get();
    }
}
