package pl.sdacademy.service;

import org.springframework.stereotype.Service;
import pl.sdacademy.model.Tuple;

import java.util.Random;

@Service
public class RandomTupleProvider implements TupleProvider {
    @Override
    public Tuple provideTuple() {
        Random random = new Random();
        return Tuple.builder()
                .first(random.nextInt(100))
                .second(random.nextInt(100)).build();
    }
}
