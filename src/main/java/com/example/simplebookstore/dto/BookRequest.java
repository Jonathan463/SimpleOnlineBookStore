package com.example.simplebookstore.dto;

import com.example.simplebookstore.enums.Category;
import com.example.simplebookstore.enums.Language;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Language language;
    @NotBlank
    private String author;
}
