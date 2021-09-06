package com.impacta.microservices.debito.demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import com.impacta.microservices.debito.demo.domain.Debito;
import com.impacta.microservices.debito.demo.service.DebitoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/debito")
public class DebitoController {

    private final DebitoService debitoService;

    public DebitoController(DebitoService debitoService) {
        this.debitoService = debitoService;
    }

    @GetMapping("findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Debito> list() throws UnknownHostException {
        System.out.println("Hostname: " + InetAddress.getLocalHost().getHostName());
        List<Debito> debitoList = debitoService.findAll();
        return debitoList;
    }

    @GetMapping("findconta")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Debito> list(Integer conta_id) throws UnknownHostException {
        System.out.println("Hostname: " + InetAddress.getLocalHost().getHostName());
        Optional<Debito> debitoList = debitoService.findById(conta_id);
        return debitoList;
    }

    @PostMapping("/inserirdebito")
    @ResponseStatus(HttpStatus.OK)
    public Debito createDebito(@RequestBody Debito debitoRequest) {
        return debitoService.create(debitoRequest);
    }
}
