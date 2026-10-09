package com.example.blooddonor.service;

import com.example.blooddonor.dto.BloodRequestMatchingResponse;
import com.example.blooddonor.entity.BloodRequest;
import com.example.blooddonor.entity.BloodRequestDonor;
import com.example.blooddonor.entity.BloodRequestStatus;
import com.example.blooddonor.entity.Donor;
import com.example.blooddonor.repository.BloodRequestDonorRepository;
import com.example.blooddonor.repository.BloodRequestRepository;
import com.example.blooddonor.repository.DonorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BloodRequestMatchingService {

    private final BloodRequestRepository bloodRequestRepository;
    private final DonorRepository donorRepository;
    private final BloodRequestDonorRepository bloodRequestDonorRepository;

    public BloodRequestMatchingService(
            BloodRequestRepository bloodRequestRepository,
            DonorRepository donorRepository,
            BloodRequestDonorRepository bloodRequestDonorRepository) {

        this.bloodRequestRepository = bloodRequestRepository;
        this.donorRepository = donorRepository;
        this.bloodRequestDonorRepository = bloodRequestDonorRepository;
    }

    @Transactional
    public BloodRequestMatchingResponse matchDonors(Long bloodRequestId) {

        BloodRequest bloodRequest = bloodRequestRepository
                .findById(bloodRequestId)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Blood request not found with id: " + bloodRequestId
                        ));

        if (bloodRequest.getStatus() != BloodRequestStatus.OPEN) {
            throw new IllegalStateException(
                    "Donors can only be matched for an OPEN blood request"
            );
        }

        List<Donor> eligibleDonors =
                donorRepository.findEligibleDonors(
                        bloodRequest.getId(),
                        bloodRequest.getBloodGroup().name(),
                        bloodRequest.getLatitude(),
                        bloodRequest.getLongitude(),
                        bloodRequest.getSearchRadiusKm()
                );

        if (eligibleDonors.isEmpty()) {
            return new BloodRequestMatchingResponse(
                    bloodRequestId,
                    0
            );
        }

        List<BloodRequestDonor> relationships = new ArrayList<>();

        for (Donor donor : eligibleDonors) {

            BloodRequestDonor relationship = new BloodRequestDonor();

            relationship.setBloodRequestId(bloodRequest.getId());
            relationship.setDonorId(donor.getId());

            relationships.add(relationship);
        }

        bloodRequestDonorRepository.saveAll(relationships);

        return new BloodRequestMatchingResponse(
                bloodRequestId,
                relationships.size()
        );
    }
}