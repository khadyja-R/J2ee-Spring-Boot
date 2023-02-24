package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Client;
import com.example.demo.entities.Operation;

public interface ClientRepository extends JpaRepository<Client,Long> {
    
}
