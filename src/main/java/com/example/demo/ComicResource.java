package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comics")
public class ComicResource {
    private final ComicRepository repository;

    @Autowired
    public ComicResource(ComicRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Comic> users(){
        return repository.findAll();
    }

    @PostMapping("save")
    public Comic save(@RequestBody Comic comic){
        Comic createdNewFavoriteComic = repository.save(comic);
        return createdNewFavoriteComic;
    }

    @GetMapping("{id_user}")
    public List<Comic> getHeroes(@PathVariable int id_user){
        return repository.findByParentId(id_user);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
        repository.deleteById(id);
        return "Favorite comic with ID " + id + " removed.";
    }
}