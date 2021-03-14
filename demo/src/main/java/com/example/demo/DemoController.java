package com.example.demo;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class DemoController {
    
    @Autowired
	private PlayerRepository playerRepository;
    
    @GetMapping(path = "/player")
    List<Player> getAll(){
        List<Player> players = new ArrayList<Player>();
        for (Player player : playerRepository.findAll()) {
            players.add(player);
		}
        return players;
    }

    @GetMapping(path = "/player/{id}")
    Player getSingle(@PathVariable Integer id) {
        return playerRepository.findById(id).get();
    }

    @PostMapping(path = "/player", consumes="application/json", produces = "application/json")
    ResponseEntity<Object> add(@RequestBody Player p) {
        
        playerRepository.save(p);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(p.getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/player/{id}", consumes="application/json", produces = "application/json")
    Player update(@PathVariable Integer id, @RequestBody Player updatedPlayer) {

        Player dbPlayer = playerRepository.findById(id).get();
        dbPlayer.setAge(updatedPlayer.getAge());
        dbPlayer.setBorn(updatedPlayer.getBorn());
        dbPlayer.setJersey(updatedPlayer.getJersey());
        dbPlayer.setNamn(updatedPlayer.getNamn());

        playerRepository.save(dbPlayer);
        
        return dbPlayer;
    }

    @DeleteMapping(path = "/player/{id}")
    void delete(@PathVariable Integer id) {
        playerRepository.deleteById(id);
    }
}