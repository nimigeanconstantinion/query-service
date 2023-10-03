package com.example.service1.controller;

import com.example.service1.model.MapStocOptim;
import com.example.service1.repository.StocOptimRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tst")
@CrossOrigin
@Slf4j
public class QueryController {
//    @Autowired
    StocOptimRepo stocOptimRepo;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<MapStocOptim> getAllMap(){
        List<MapStocOptim> lista=stocOptimRepo.findAll();
        log.info("Content BD map_stoc_optim",lista);
        return stocOptimRepo.findAll();
    }

}
