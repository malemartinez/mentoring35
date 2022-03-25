package co.com.sofka.mentoring35;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Mono<Random> post(@RequestBody RequestDTO request) {
        return Mono.just(new Random()).map(entity -> {
            entity.setDate(new Date());
            entity.setNumberDices(request.getDiceNumber());
            return entity;
        }).map(entity -> {

            var lista = new ArrayList<>(request.getDiceNumber());
            var list = Stream.of(request.getDiceNumber())
                    .collect(Collectors.toList()).stream()
                    .map( item -> {
                        int numberRandom = (int) (Math.random()*(6 - 1+ 1) + 6);
                        item = numberRandom;
                                return item;
                        }
                    ).collect(Collectors.toList());


            //generar numeros aleatorios del 1 al 6
//            (int)(Math.random()*(HASTA-DESDE+1)+DESDE)

            var randomList = list;
            entity.setRandomList(randomList);
            return entity;
        }).flatMap(randomRepository::save);
    }

    @GetMapping("")
    public Flux<Random> get() {
        return randomRepository.findAll();
    }
}
