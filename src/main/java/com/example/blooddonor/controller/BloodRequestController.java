package com.example.blooddonor.controller;

import com.example.blooddonor.dto.BloodRequestCreateRequest;
import com.example.blooddonor.dto.BloodRequestMatchingResponse;
import com.example.blooddonor.dto.BloodRequestResponse;
import com.example.blooddonor.service.BloodRequestMatchingService;
import com.example.blooddonor.service.BloodRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blood-requests")
public class BloodRequestController {

    private final BloodRequestService bloodRequestService;
    private final BloodRequestMatchingService bloodRequestMatchingService;

    public BloodRequestController(
            BloodRequestService bloodRequestService,
            BloodRequestMatchingService bloodRequestMatchingService) {

        this.bloodRequestService = bloodRequestService;
        this.bloodRequestMatchingService = bloodRequestMatchingService;
    }

    @PostMapping
    public ResponseEntity<BloodRequestResponse> createBloodRequest(
            @Valid @RequestBody BloodRequestCreateRequest request) {

        BloodRequestResponse response =
                bloodRequestService.createBloodRequest(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
    @PostMapping("/{bloodRequestId}/match")
    public ResponseEntity<BloodRequestMatchingResponse> matchDonors(
            @PathVariable Long bloodRequestId) {

        BloodRequestMatchingResponse response =
                bloodRequestMatchingService.matchDonors(bloodRequestId);

        return ResponseEntity.ok(response);
    }
}