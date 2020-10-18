package pl.sdacademy.service;

import lombok.extern.slf4j.Slf4j;
import pl.sdacademy.model.Tuple;

import java.util.Random;

@Slf4j
public class RandomTupleProvider implements TupleProvider {
    @Override
    public Tuple provideTuple() {
        log.info("random tuple provider processing.. ");
        Random random = new Random();
        return Tuple.builder()
                .first(random.nextInt(100))
                .second(random.nextInt(100)).build();
    }
}
