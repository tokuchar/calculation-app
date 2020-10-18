package pl.sdacademy.service;

import org.springframework.stereotype.Service;
import pl.sdacademy.model.CalculationRequest;
import pl.sdacademy.model.CalculationResponse;
import pl.sdacademy.model.Tuple;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class Calculator {
    final Map<String, TupleProvider> tupleProviders;

    public Calculator(Map<String, TupleProvider> tupleProviders) {
        this.tupleProviders = tupleProviders;
    }

    public CalculationResponse doMagic(CalculationRequest calculationRequest) {
        TupleProvider tupleProvider = tupleProviders.get(calculationRequest.getDataSourceType().name());
        Tuple tuple = tupleProvider.provideTuple();

        BigDecimal result = new BigDecimal(tuple.getFirst().toString())
                .add(new BigDecimal(tuple.getSecond().toString()));
        return CalculationResponse.builder()
                .result(result)
                .tuple(tuple).build();
    }
}
