package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // templates/index.html を表示
    }
    
    @GetMapping("/profile")
    public String profile() {
        return "profile"; // templates/profile.html を表示
    }
    
    @GetMapping("/contact")
    public String contact() {
        return "contact"; // templates/contact.html を表示
    }

    @PostMapping("/contact")
    public String submitContact(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String message) {
        // ここでメール送信やDB保存などの処理を行う（今回は省略）
        System.out.println("お問い合わせ：" + name + " / " + email + " / " + message);
        return "thankyou"; // 送信後のページへ
    }

}
