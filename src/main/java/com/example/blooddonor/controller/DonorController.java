package com.example.blooddonor.controller;

import com.example.blooddonor.dto.DonorRequest;
import com.example.blooddonor.dto.DonorResponse;
import com.example.blooddonor.entity.Donor;
import com.example.blooddonor.service.DonorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.blooddonor.dto.DonorStatusUpdateRequest;
import com.example.blooddonor.entity.DonorStatus;


import java.util.List;

@RestController
@RequestMapping("/api/donors")
public class DonorController {

    private final DonorService donorService;

    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    @PostMapping
    public ResponseEntity<DonorResponse> createDonor(
            @Valid @RequestBody DonorRequest request) {

        Donor donor = new Donor();

        donor.setName(request.getName());
        donor.setPhone(request.getPhone());
        donor.setEmail(request.getEmail());
        donor.setBloodGroup(request.getBloodGroup());
        donor.setAddress(request.getAddress());
        donor.setLandmark(request.getLandmark());
        donor.setLatitude(request.getLatitude());
        donor.setLongitude(request.getLongitude());
        donor.setSearchRadiusKm(request.getSearchRadiusKm());
        donor.setDonationFrequencyDays(request.getDonationFrequencyDays());
        donor.setLastDonationDate(request.getLastDonationDate());

        Donor createdDonor = donorService.createDonor(donor);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(createdDonor));
    }

    @GetMapping
    public ResponseEntity<List<DonorResponse>> getAllDonors() {

        List<DonorResponse> donors = donorService.getAllDonors()
                .stream()
                .map(this::toResponse)
                .toList();

        return ResponseEntity.ok(donors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonorResponse> getDonorById(
            @PathVariable Long id) {

        Donor donor = donorService.getDonorById(id);

        return ResponseEntity.ok(toResponse(donor));
    }

    private DonorResponse toResponse(Donor donor) {

        DonorResponse response = new DonorResponse();

        response.setId(donor.getId());
        response.setName(donor.getName());
        response.setPhone(donor.getPhone());
        response.setEmail(donor.getEmail());
        response.setBloodGroup(donor.getBloodGroup());
        response.setAddress(donor.getAddress());
        response.setLandmark(donor.getLandmark());
        response.setLatitude(donor.getLatitude());
        response.setLongitude(donor.getLongitude());
        response.setSearchRadiusKm(donor.getSearchRadiusKm());
        response.setDonationFrequencyDays(donor.getDonationFrequencyDays());
        response.setLastDonationDate(donor.getLastDonationDate());
        response.setStatus(donor.getStatus());
        response.setCreatedAt(donor.getCreatedAt());
        response.setUpdatedAt(donor.getUpdatedAt());

        return response;
    }
    @PutMapping("/{id}")
    public ResponseEntity<DonorResponse> updateDonor(
            @PathVariable Long id,
            @Valid @RequestBody DonorRequest.DonorUpdateRequest request) {

        Donor updatedDonor = donorService.updateDonor(id, request);

        return ResponseEntity.ok(toResponse(updatedDonor));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DonorResponse> deleteDonor(
            @PathVariable Long id) {

        Donor updatedDonor = donorService.updateDonorStatus(
                id,
                DonorStatus.INACTIVE
        );

        return ResponseEntity.ok(toResponse(updatedDonor));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<DonorResponse> updateDonorStatus(
            @PathVariable Long id,
            @Valid @RequestBody DonorStatusUpdateRequest request) {

        Donor updatedDonor = donorService.updateDonorStatus(
                id,
                request.getStatus()
        );

        return ResponseEntity.ok(toResponse(updatedDonor));
    }
}