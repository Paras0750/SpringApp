package com.newproject.newproject.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.newproject.newproject.model.Alien;
import com.newproject.newproject.repo.AlienRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
// @RestController
public class AlienController {

    private final AlienRepo repo;

    public AlienController(AlienRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    @ResponseBody
    public String home() {
        return "HEY!!";
    }

    @GetMapping("/aliens")
    @ResponseBody
    public List<Alien> getAliens() {
        return repo.findAll();
    }

    @GetMapping("/alien/{id}")
    @ResponseBody
    public List<Alien> getAlien(@PathVariable("id") int id) {
        return repo.getOne(id).isEmpty() ? null : repo.getOne(id);
    }

    @PostMapping("/alien")
    @ResponseBody
    public Alien addAlien(Alien alien) {
        repo.save(alien);
        return alien;
    }

}
