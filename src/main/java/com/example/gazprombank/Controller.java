package com.example.gazprombank;

import com.example.gazprombank.model.Recipient;
import com.example.gazprombank.service.MailService;
import com.example.gazprombank.service.RecipientService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipient")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Controller {

    MailService mailService;
    RecipientService recipientService;

    @GetMapping(value = "/view")
    public ResponseEntity<List<Recipient>> getRecipient() {
        return ResponseEntity.ok(recipientService.list());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Recipient> getRecipient(@RequestBody Recipient recipient) {
        return ResponseEntity.ok(
                recipientService.save(recipient)
        );
    }

    @DeleteMapping()
    public ResponseEntity<Recipient> deleteRecipient(@PathVariable("id") String id) {
        return null;
    }

    @GetMapping(value = "/send")
    public void sendMessage() {
        mailService.send();
    }
}
