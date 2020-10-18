package pl.sdacademy.service;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class FooBeanA {
    private final FooBeanB fooBeanB;

    public FooBeanA(FooBeanB fooBeanB) {
        this.fooBeanB = fooBeanB;
    }
//    private final ApplicationContext applicationContext;
//
//    public FooBeanA(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//
//    private void makeGigaMagic(){
//        FooBeanB fooBeanB = applicationContext.getBean(FooBeanB.class);
//    }
}
