package pl.sdacademy.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sdacademy.model.Tuple;

import java.math.BigDecimal;

@Service
public class ExternalApiTupleProvider implements TupleProvider {
    @Override
    public Tuple provideTuple() {
        RestTemplate restTemplate = new RestTemplate();
        String[] ints = restTemplate
                .getForEntity("https://www.random.org/integers/?num=2&min=1&max=100&col=1&base=10&format=plain&rnd=new", String.class)
                .getBody()
                .split("\\r?\\n");

        return Tuple.builder()
                .first(new BigDecimal(ints[0]))
                .second(new BigDecimal(ints[1])).build();
    }
}
