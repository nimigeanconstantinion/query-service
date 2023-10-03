package com.example.service1.controller;

import com.example.service1.model.MapStocOptim;
import com.example.service1.repository.TestRepository;
import com.example.service1.service.MapStocOptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/query")
@CrossOrigin
@Slf4j
public class TestController {

    private MapStocOptService mapStocOptService;

    public TestController(MapStocOptService mapStocOptService) {
        this.mapStocOptService = mapStocOptService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public ResponseEntity<List<MapStocOptim>> getAll(){
        List<MapStocOptim> lista=mapStocOptService.getAllMapStocOpt();
        log.info("Am primit rezultat din getAll",lista.stream().map(m->m.getArticol()).collect(Collectors.toList()));
        
        return ResponseEntity.ok(lista);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/byid/{ida}")
    public ResponseEntity<MapStocOptim> getById(@PathVariable String ida) {

        try{
            MapStocOptim mp=mapStocOptService.getMapStocOptByID(ida);
            return ResponseEntity.ok(mp);
        }catch (RuntimeException e){
            throw e;
        }


    }

}
