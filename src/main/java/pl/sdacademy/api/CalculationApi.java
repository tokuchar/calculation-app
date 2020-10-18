package pl.sdacademy.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.model.CalculationRequest;
import pl.sdacademy.model.CalculationResponse;
import pl.sdacademy.service.Calculator;
import pl.sdacademy.service.FooBeanPrototype;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@Scope(BeanDefinition.SCOPE_SINGLETON)
@EnableSwagger2
@Slf4j
public class CalculationApi {
    final Calculator calculator;

    @Lookup
    public FooBeanPrototype getFooBeanPrototype() {
        return null;
    }

    public CalculationApi(Calculator calculator) {
        this.calculator = calculator;
    }

    @PostMapping(path = "/calculation")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CalculationResponse> invokeOperation(@RequestBody CalculationRequest calculationRequest) {
        log.info("calculation start :)");
        return ResponseEntity.ok(calculator.doMagic(calculationRequest));
    }

    @PostMapping(path = "/hey")
    public void hey(){
        getFooBeanPrototype().hey();
    }
}
