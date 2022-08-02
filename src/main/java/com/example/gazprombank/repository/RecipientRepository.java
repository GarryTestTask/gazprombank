package com.example.gazprombank.repository;

import com.example.gazprombank.model.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Integer> {

    @Query(value = "SELECT address FROM recipients", nativeQuery = true)
    List<String> findAllAddresses();

    @Override
    Recipient saveAndFlush(Recipient recipient);

    @Override
    List<Recipient> findAll();
}
