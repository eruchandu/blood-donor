package com.example.blooddonor.controller;

import com.example.blooddonor.dto.BloodRequestDonorResponse;
import com.example.blooddonor.entity.BloodRequestDonorStatus;
import com.example.blooddonor.service.BloodRequestDonorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam BloodRequestDonorStatus status) {

        BloodRequestDonorResponse response =
                bloodRequestDonorService.updateDonorResponse(
                        relationshipId,
                        donorId,
                        status
                );

        return ResponseEntity.ok(response);
    }
}