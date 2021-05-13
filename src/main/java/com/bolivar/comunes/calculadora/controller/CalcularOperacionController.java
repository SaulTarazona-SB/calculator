package com.bolivar.comunes.calculadora.controller;

import com.bolivar.comunes.calculadora.models.ObtenercalculoResponse;
import com.bolivar.comunes.calculadora.service.CalcularOperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularOperacionController {

    @Autowired
    public CalcularOperacionService calculoService;

    @PostMapping("/api/v1/calculadora/suma")
    public ResponseEntity<ObtenercalculoResponse> sumar(@RequestParam int numA, @RequestParam int numB) {
        return ResponseEntity.ok(calculoService.sumar(numA, numB));
    }

    @PostMapping("/api/v1/calculadora/resta")
    public ResponseEntity<ObtenercalculoResponse> restar(@RequestParam int numA, @RequestParam int numB) {
        return ResponseEntity.ok(calculoService.restar(numA, numB));
    }

    @PostMapping("/api/v1/calculadora/multiplicacion")
    public ResponseEntity<ObtenercalculoResponse> multiplicar(@RequestParam int numA, @RequestParam int numB) {
        return ResponseEntity.ok(calculoService.multiplicar(numA, numB));
    }

    @PostMapping("/api/v1/calculadora/division")
    public ResponseEntity<ObtenercalculoResponse> dividir(@RequestParam int numA, @RequestParam int numB) {
        return ResponseEntity.ok(calculoService.dividir(numA, numB));
    }

}
