package com.sampleapi.SortandFilter.controller;

import com.sampleapi.SortandFilter.model.Beer;
import com.sampleapi.SortandFilter.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beers")
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    public List<Beer> getBeers(@RequestParam(required = false) String sort,
                               @RequestParam(required = false) Double minRating) {
        if ("price".equalsIgnoreCase(sort)) {
            return beerService.sortByPrice();
        } else if (minRating != null) {
            return beerService.filterByRating(minRating);
        }
        return beerService.getAllBeers();
    }
}



