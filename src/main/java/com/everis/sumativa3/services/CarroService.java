package com.everis.sumativa3.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.sumativa3.models.Carro;
import com.everis.sumativa3.repositories.CarroRepository;

@Service
public class CarroService {
	@Autowired
	CarroRepository carroRepository;
	
	public Carro save(Carro carro) {
		return carroRepository.save(carro);
	}
	public List<Carro> findAll() {
		return carroRepository.findAll();
	}
	public void deleteById(Long id) {
		carroRepository.deleteById(id);
	}
}
