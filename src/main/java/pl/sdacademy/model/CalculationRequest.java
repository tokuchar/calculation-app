package pl.sdacademy.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CalculationRequest {
    private OperationType operation;
    private DataSourceType dataSourceType;
}
