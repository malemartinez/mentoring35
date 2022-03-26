package co.com.sofka.mentoring35;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/dicesRoller")
public class RandomController {

    private RandomRepository randomRepository;

    @Autowired
    public RandomController(RandomRepository randomRepository) {
        this.randomRepository = randomRepository;
    }

    @PostMapping("")
    public Mono<Random> post() {
        Integer valorDado1 = (new java.util.Random().nextInt(6) + 1);
        Integer valorDado2 = (new java.util.Random().nextInt(6) + 1);
        List<Integer> lista = new ArrayList<>();
        return Mono.just(new Random()).map(entity -> {
            entity.setDate(new Date());
            entity.setDice1(valorDado1);
            entity.setDice2(valorDado2);
            lista.add(valorDado1);
            lista.add(valorDado2);
            entity.setList( lista );
            return entity;
        }).flatMap(randomRepository::save);
    }

    @GetMapping("")
    public Flux<Random> get() {
        return randomRepository.findAll();
    }

}
