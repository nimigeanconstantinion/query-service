package com.example.service1.controller;

import com.example.service1.model.MapStocOptim;
import com.example.service1.repository.StocOptimRepo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tst")
//@CrossOrigin
@Slf4j
public class QueryController {
//    @Autowired
    StocOptimRepo stocOptimRepo;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<MapStocOptim> getAllMap(HttpServletRequest request){

        List<MapStocOptim> lista=stocOptimRepo.findAll();
        System.out.println("******************* am obtinut lista");
        String authorizationHeader = request.getHeader("Authorization");

        String jwtToken = null;

        // Verificăm dacă header-ul Authorization este prezent și începe cu "Bearer "
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            // Extragem tokenul JWT eliminând prefixul "Bearer "
            jwtToken = authorizationHeader.substring(7);
        }

        // Aici poți folosi jwtToken pentru a valida utilizatorul sau pentru alte operațiuni
        System.out.println("====JWT Token: " + jwtToken);

        return stocOptimRepo.findAll();
    }

}
