package pl.sdacademy.service;

import pl.sdacademy.model.CalculationRequest;
import pl.sdacademy.model.CalculationResponse;
import pl.sdacademy.model.Tuple;

import java.math.BigDecimal;

public class Calculator {
    final TupleProvider tupleProvider;

    public Calculator(TupleProvider tupleProvider) {
        this.tupleProvider = tupleProvider;
    }


    public CalculationResponse doMagic(CalculationRequest calculationRequest) {
//        TupleProvider tupleProvider = tupleProviders.get(calculationRequest.getDataSourceType().name());
        Tuple tuple = tupleProvider.provideTuple();

        BigDecimal result = new BigDecimal(tuple.getFirst().toString())
                .add(new BigDecimal(tuple.getSecond().toString()));
        return CalculationResponse.builder()
                .result(result)
                .tuple(tuple).build();

    }
}
