package com.example.gazprombank.service;

import com.example.gazprombank.model.Recipient;

import java.util.List;

public interface RecipientService {

    /**
     * Сохранение получателя
     */
    Recipient save(Recipient recipient);

    /**
     * Список всех получателей
     */
    List<Recipient> list();

    /**
     * Список адресов почты
     */
    List<String> getAddresses();
}
