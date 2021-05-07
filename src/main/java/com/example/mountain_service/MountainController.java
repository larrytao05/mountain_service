package com.example.mountain_service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class MountainController {
    ArrayList<HashMap<Double[], Double[]>> mountains = new ArrayList<>();

    @GetMapping("/create")
    public void create(@RequestParam(value = "id", defaultValue = "null") int id
            , @RequestParam String climate
            , @RequestParam boolean waterPresent
            , @RequestParam int difficulty
            , @RequestParam int steepness
            , @RequestParam int width
            , @RequestParam int height) throws JsonProcessingException {
        HashMap<Double[], Double[]> m = new HashMap<>();
        //input mountain values here

        //store server side

        mountains.add(id, m);

    }

    @GetMapping("/mountain")
    public String mountain(@RequestParam(value = "id", defaultValue = "null") int id) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(mountains.get(id));
        return json;
    }

    @GetMapping("/coordinate")
    public String coordinate(@RequestParam int id, @RequestParam double x, @RequestParam double y) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(mountains.get(id).get(new double[]{x, y}));
        return json;
    }
}
