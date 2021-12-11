package com.riyaz.spring.jpa.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riyaz.spring.jpa.h2.model.Employees;

@Repository
public interface Mydaorepository extends JpaRepository<Employees, Integer> {

}