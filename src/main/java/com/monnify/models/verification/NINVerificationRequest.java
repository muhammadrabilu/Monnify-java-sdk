package com.monnify.models.verification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NINVerificationRequest {
    @Pattern(regexp = "\\d{11}", message = "NIN must be an 11-digit number")
    @NotBlank(message = "nin is required")
    private String nin;
}
