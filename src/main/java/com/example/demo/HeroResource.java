package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("heroes")
public class HeroResource {
    private final HeroRepository repository;

    @Autowired
    public HeroResource(HeroRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Hero> users(){
        return repository.findAll();
    }

    @PostMapping("save")
    public Hero save(@RequestBody Hero hero){
        Hero createdNewFavoriteHero = repository.save(hero);
        return createdNewFavoriteHero;
    }

    @GetMapping("{id_user}")
    public List<Hero> getHeroes(@PathVariable int id_user){
        return repository.findByParentId(id_user);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
        repository.deleteById(id);
        return "Favorite hero with ID " + id + " removed.";
    }
}