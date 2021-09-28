package com.springmvcountries.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvcountries.demo.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
