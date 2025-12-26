package com.portella.front.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Controller
public class ApiController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/call-api")
    public String callApi(Model model) {

      String apiUrl = "http://localhost:8081/auth"; // ajuste a porta correta

        try {
            String response = restTemplate.getForObject(apiUrl, String.class);
            model.addAttribute("apiResponse", response);
            model.addAttribute("success", true);

        } catch (ResourceAccessException e) {
            // Erro de conexão (API fora do ar)
            model.addAttribute("apiResponse",
                    "❌ Não foi possível conectar à API. Verifique se o servidor está online.");
            model.addAttribute("success", false);

        } catch (RestClientException e) {
            // Outros erros HTTP (500, 404, etc)
            model.addAttribute("apiResponse",
                    "⚠️ A API respondeu com erro: " + e.getMessage());
            model.addAttribute("success", false);
        }

        return "dashboard";
    }
}