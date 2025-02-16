package com.sil.bejpamvc.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminMemberController {

    @GetMapping("/admin/member")
    public String adminMember() {
        return "member/adminMember";
    }
}
