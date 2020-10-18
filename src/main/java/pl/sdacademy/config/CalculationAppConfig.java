package pl.sdacademy.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sdacademy.service.*;

@Configuration
@EnableAutoConfiguration
public class CalculationAppConfig {

    @Bean(name = "EXTERNAL_API")
    public TupleProvider externalApiTupleProvider(){
        return new ExternalApiTupleProvider("https://www.random.org/integers/?num=2&min=1&max=100&col=1&base=10&format=plain&rnd=new");
    }

    @Bean(name = "RANDOM")
    public TupleProvider randomTupleProvider(){
        return new RandomTupleProvider();
    }

    @Bean
    public Calculator calculator(@Qualifier("EXTERNAL_API") TupleProvider tupleProvider){
        return new Calculator(tupleProvider);
    }
}
