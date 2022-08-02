package com.example.gazprombank.service.impl;

import com.example.gazprombank.model.Recipient;
import com.example.gazprombank.repository.RecipientRepository;
import com.example.gazprombank.service.RecipientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecipientServiceImpl implements RecipientService {

    final RecipientRepository recipientRepository;

    @Override
    @Caching(evict = {
            @CacheEvict(value = "addresses", allEntries = true),
            @CacheEvict(value = "recipients", allEntries = true)
    })
    public Recipient save(Recipient recipient) {
        return recipientRepository.saveAndFlush(recipient);
    }

    @Override
    @Cacheable("recipients")
    public List<Recipient> list() {
        return recipientRepository.findAll();
    }

    @Override
    @Cacheable("addresses")
    public List<String> getAddresses() {
        return recipientRepository.findAllAddresses();
    }

}
