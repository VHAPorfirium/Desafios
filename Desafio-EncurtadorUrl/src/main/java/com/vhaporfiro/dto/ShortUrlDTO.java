package com.vhaporfiro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShortUrlDTO {

    @JsonProperty("url")
    @NotBlank(message = "O campo originalUrl é obrigatório.")
    private String originalUrl;

}
