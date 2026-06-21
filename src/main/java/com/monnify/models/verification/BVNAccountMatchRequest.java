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
public class BVNAccountMatchRequest {
    @NotBlank(message = "bankCode is required")
    private String bankCode;
    @NotBlank(message = "accountNumber is required")
    private String accountNumber;
    @NotBlank(message = "bvn is required")
    @Pattern(regexp = "\\d{11}", message = "BVN must be an 11-digit number")
    private String bvn;
}
