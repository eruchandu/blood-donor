package com.example.blooddonor.service;

import com.example.blooddonor.entity.BloodRequestDonor;
import com.example.blooddonor.entity.BloodRequestDonorStatus;
import com.example.blooddonor.repository.BloodRequestDonorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.blooddonor.dto.BloodRequestDonorResponse;

@Service
public class BloodRequestDonorService {

    private final BloodRequestDonorRepository bloodRequestDonorRepository;

    public BloodRequestDonorService(
            BloodRequestDonorRepository bloodRequestDonorRepository) {

        this.bloodRequestDonorRepository =
                bloodRequestDonorRepository;
    }

    @Transactional
    public BloodRequestDonorResponse updateDonorResponse(
            Long relationshipId,
            Long donorId,
            BloodRequestDonorStatus newStatus) {

        BloodRequestDonor relationship =
                bloodRequestDonorRepository
                        .findByIdAndDonorId(relationshipId, donorId)
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Blood request donor relationship not found"
                                ));

        if (relationship.getStatus()
                != BloodRequestDonorStatus.NOTIFIED) {

            throw new IllegalStateException(
                    "Donor has already responded to this blood request"
            );
        }

        if (newStatus != BloodRequestDonorStatus.ACCEPTED
                && newStatus != BloodRequestDonorStatus.REJECTED) {

            throw new IllegalArgumentException(
                    "Donor can only ACCEPT or REJECT a request"
            );
        }

        relationship.setStatus(newStatus);

        BloodRequestDonor savedRelationship =
                bloodRequestDonorRepository.save(relationship);

        return toResponse(savedRelationship);
    }
    private BloodRequestDonorResponse toResponse(
            BloodRequestDonor relationship) {

        BloodRequestDonorResponse response =
                new BloodRequestDonorResponse();

        response.setId(relationship.getId());
        response.setBloodRequestId(
                relationship.getBloodRequestId()
        );
        response.setDonorId(
                relationship.getDonorId()
        );
        response.setStatus(
                relationship.getStatus()
        );
        response.setNotificationCount(
                relationship.getNotificationCount()
        );
        response.setLastNotifiedAt(
                relationship.getLastNotifiedAt()
        );
        response.setCreatedAt(
                relationship.getCreatedAt()
        );
        response.setUpdatedAt(
                relationship.getUpdatedAt()
        );

        return response;
    }
}