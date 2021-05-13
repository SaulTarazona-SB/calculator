package com.bolivar.comunes.calculadora.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CalcularOperacionConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.bolivar.comunes.calculadora.consumingwebservice.wsdl");
        return marshaller;
    }

    @Bean
    public CalcularOperacionService calcularOperacionesService (Jaxb2Marshaller marshaller) {
        CalcularOperacionService client = new CalcularOperacionService();
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
