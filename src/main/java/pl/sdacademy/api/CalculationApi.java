package pl.sdacademy.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.model.CalculationRequest;
import pl.sdacademy.model.CalculationResponse;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@Slf4j
public class CalculationApi {

    @PostMapping(path = "/calculaton")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CalculationResponse> invokeOperation(@RequestBody CalculationRequest calculationRequest){
//        log.
        return null;
    }
}