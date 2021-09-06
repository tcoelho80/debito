package com.impacta.microservices.debito.demo.service;

import java.util.List;
import java.util.Optional;

import com.impacta.microservices.debito.demo.domain.Debito;
import com.impacta.microservices.debito.demo.repository.DebitoRepository;
import org.springframework.stereotype.Component;


@Component
public class DebitoService {

    private DebitoRepository repository;

    public DebitoService(DebitoRepository repository) {
        this.repository = repository;
    }

    public Debito create(Debito debito) {
        return repository.save(debito);
    }

    public List<Debito> findAll() {
        return repository.findAll();
    }

    public boolean findConta(Integer Id) {
        return repository.existsById(Id);
    }

    public Optional<Debito> findById(Integer conta_id) {
        return repository.findById(conta_id);
    }
}
