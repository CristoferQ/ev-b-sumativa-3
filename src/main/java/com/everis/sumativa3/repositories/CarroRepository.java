package com.everis.sumativa3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.sumativa3.models.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

}
