package com.sampleapi.SortandFilter.service;

import com.sampleapi.SortandFilter.model.Beer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class BeerService {

    private final String API_URL ="https://api.sampleapis.com/beers/ale";


    public List<Beer> sortByPrice() {
        List<Beer> beers = getAllBeers();
        beers.sort(new Comparator<Beer>() {
            @Override
            public int compare(Beer b1, Beer b2) {
                return Double.compare(b1.getPriceDoubleLiteral(), b2.getPriceDoubleLiteral());
            }
        });
        return beers;
    }

    public List<Beer> filterByRating(Double minRating) {
        List<Beer> beers = getAllBeers();
        List<Beer> result = new ArrayList<>();

        for (Beer b : beers) {
            if (b.getRating() != null && b.getRating().getAverage() >= minRating) {
                result.add(b);
            }
        }

        return result;

    }

    public List<Beer> getAllBeers() {

        RestTemplate restTemplate = new RestTemplate();
        Beer[] beers = restTemplate.getForObject(API_URL,Beer[].class);

        return Arrays.asList(beers);


    }
}
