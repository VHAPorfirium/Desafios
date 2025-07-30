package com.vhaporfiro.controller;

import com.vhaporfiro.dto.ShortUrlDTO;
import com.vhaporfiro.dto.ShortUrlResponseDTO;
import com.vhaporfiro.service.ShortenerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping
public class ShortenerController {

    private final ShortenerService shortenerService;

    public ShortenerController(ShortenerService shortenerService) {
        this.shortenerService = shortenerService;
    }

    @PostMapping("/shorten-url")
    public ResponseEntity<ShortUrlResponseDTO> shortenUrl(@Valid @RequestBody ShortUrlDTO dto) {
        ShortUrlResponseDTO response = shortenerService.createShortUrl(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{shortCode}")
    public RedirectView redirectToOriginalUrl(@PathVariable String shortCode) {
        try {
            String originalUrl = shortenerService.getOriginalUrl(shortCode);
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl(originalUrl);
            return redirectView;
        } catch (RuntimeException e) {
            RedirectView redirectView = new RedirectView();
            redirectView.setStatusCode(HttpStatus.NOT_FOUND);
            redirectView.setUrl("/not-found");
            return redirectView;
        }
    }
}
