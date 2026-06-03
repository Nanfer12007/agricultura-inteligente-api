package com.fiap.agricultura.controller;

import org.springframework.web.bind.annotation.*;

import com.fiap.agricultura.dto.response.DashboardDTO;
import com.fiap.agricultura.service.DashboardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService service;

    @GetMapping
    public DashboardDTO dashboard() {

        return service.obterDashboard();
    }
}