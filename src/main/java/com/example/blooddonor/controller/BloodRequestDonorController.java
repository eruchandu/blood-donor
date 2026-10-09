package com.example.blooddonor.controller;

import com.example.blooddonor.dto.BloodRequestDonorResponse;
import com.example.blooddonor.entity.BloodRequestDonorStatus;
import com.example.blooddonor.service.BloodRequestDonorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.blooddonor.dto.BloodRequestDonorResponseRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/blood-request-donors")
public class BloodRequestDonorController {

    private final BloodRequestDonorService bloodRequestDonorService;

    public BloodRequestDonorController(
            BloodRequestDonorService bloodRequestDonorService) {

        this.bloodRequestDonorService =
                bloodRequestDonorService;
    }

    @PatchMapping("/{relationshipId}/response")
    public ResponseEntity<BloodRequestDonorResponse> updateDonorResponse(
            @PathVariable Long relationshipId,
            @RequestParam Long donorId,
            @Valid @RequestBody BloodRequestDonorResponseRequest request) {

        BloodRequestDonorResponse response =
                bloodRequestDonorService.updateDonorResponse(
                        relationshipId,
                        donorId,
                        request
                );

        return ResponseEntity.ok(response);
    }
}