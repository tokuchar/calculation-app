package pl.sdacademy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sdacademy.model.Tuple;

import java.math.BigDecimal;

@Slf4j
@Service("EXTERNAL_API")
public class ExternalApiTupleProvider implements TupleProvider {
    @Override
    public Tuple provideTuple() {
        log.info("external api tuple provider processing.. ");
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
