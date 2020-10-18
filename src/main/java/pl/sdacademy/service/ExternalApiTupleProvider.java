package pl.sdacademy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import pl.sdacademy.model.Tuple;

import java.math.BigDecimal;

@Slf4j
public class ExternalApiTupleProvider implements TupleProvider {
    final String randomOrgUrl;

    public ExternalApiTupleProvider(String randomOrgUrl) {
        this.randomOrgUrl = randomOrgUrl;
    }

    @Override
    public Tuple provideTuple() {
        log.info("external api tuple provider processing.. ");
        RestTemplate restTemplate = new RestTemplate();
        String[] ints = restTemplate
                .getForEntity(randomOrgUrl, String.class)
                .getBody()
                .split("\\r?\\n");

        return Tuple.builder()
                .first(new BigDecimal(ints[0]))
                .second(new BigDecimal(ints[1])).build();
    }
}
