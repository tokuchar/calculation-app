package pl.sdacademy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Service
public class FooBeanPrototype {
    private final LocalDateTime creationTime;

    public FooBeanPrototype() {
        this.creationTime = LocalDateTime.now();
    }

    public void hey(){
        log.info("FooBeanPrototype creation date: " + creationTime.toString());
    }
}
