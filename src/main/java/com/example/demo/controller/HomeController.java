package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;

@Controller
public class HomeController {

    private final ContactRepository contactRepository;

    @Autowired
    public HomeController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String message) {
        Contact contact = new Contact(name, email, message);
        contactRepository.save(contact); // DBに保存
        return "thankyou";
    }

    @GetMapping("/contact/list")
    public String contactList(Model model) {
        model.addAttribute("contacts", contactRepository.findAll()); // DBから取得
        return "contactlist";
    }
    
    @GetMapping("/services")
    public String services() {
        return "services";
    }
}