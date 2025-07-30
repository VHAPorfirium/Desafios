package com.vhaporfiro.service;

import com.vhaporfiro.dto.ShortUrlDTO;
import com.vhaporfiro.dto.ShortUrlResponseDTO;
import com.vhaporfiro.entities.ShortUrl;
import com.vhaporfiro.repository.ShortUrlRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class ShortenerService {

    private final ShortUrlRepository repository;
    private final Random random = new Random();

    @Value("${app.base-url}")
    private String baseUrl;

    public ShortenerService(ShortUrlRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ShortUrlResponseDTO createShortUrl(ShortUrlDTO dto) {
        String shortCode = generateUniqueShortCode();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiresAt = now.plusDays(30);

        ShortUrl entity = new ShortUrl();
        entity.setOriginalUrl(dto.getOriginalUrl());
        entity.setShortCode(shortCode);
        entity.setCreatedAt(now);
        entity.setExpiresAt(expiresAt);

        repository.save(entity);

        return new ShortUrlResponseDTO(baseUrl + "/" + shortCode);
    }

    private String generateUniqueShortCode() {
        String code;
        do {
            code = generateRandomCode(5, 10);
        } while (repository.existsByShortCode(code));
        return code;
    }

    private String generateRandomCode(int minLength, int maxLength) {
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }

    public String getOriginalUrl(String shortCode) {
        ShortUrl entity = repository.findByShortCode(shortCode)
                .filter(url -> url.getExpiresAt().isAfter(LocalDateTime.now()))
                .orElseThrow(() -> new RuntimeException("URL não encontrada ou expirada"));
        return entity.getOriginalUrl();
    }
}
