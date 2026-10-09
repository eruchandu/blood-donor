package com.example.blooddonor.service;

import com.example.blooddonor.dto.BloodRequestCreateRequest;
import com.example.blooddonor.dto.BloodRequestResponse;
import com.example.blooddonor.entity.BloodRequest;
import com.example.blooddonor.repository.BloodRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class BloodRequestService {

    private final BloodRequestRepository bloodRequestRepository;

    public BloodRequestService(BloodRequestRepository bloodRequestRepository) {
        this.bloodRequestRepository = bloodRequestRepository;
    }

    public BloodRequestResponse createBloodRequest(
            BloodRequestCreateRequest request) {

        BloodRequest bloodRequest = new BloodRequest();

        bloodRequest.setRequestorId(request.getRequestorId());
        bloodRequest.setBloodGroup(request.getBloodGroup());
        bloodRequest.setRequiredUnits(request.getRequiredUnits());
        bloodRequest.setAddress(request.getAddress());
        bloodRequest.setLandmark(request.getLandmark());
        bloodRequest.setLatitude(request.getLatitude());
        bloodRequest.setLongitude(request.getLongitude());
        bloodRequest.setSearchRadiusKm(request.getSearchRadiusKm());

        BloodRequest savedRequest =
                bloodRequestRepository.save(bloodRequest);

        return toResponse(savedRequest);
    }

    private BloodRequestResponse toResponse(BloodRequest bloodRequest) {

        BloodRequestResponse response = new BloodRequestResponse();

        response.setId(bloodRequest.getId());
        response.setRequestorId(bloodRequest.getRequestorId());
        response.setBloodGroup(bloodRequest.getBloodGroup());
        response.setRequiredUnits(bloodRequest.getRequiredUnits());
        response.setCompletedUnits(bloodRequest.getCompletedUnits());
        response.setAddress(bloodRequest.getAddress());
        response.setLandmark(bloodRequest.getLandmark());
        response.setLatitude(bloodRequest.getLatitude());
        response.setLongitude(bloodRequest.getLongitude());
        response.setSearchRadiusKm(bloodRequest.getSearchRadiusKm());
        response.setStatus(bloodRequest.getStatus());
        response.setCreatedAt(bloodRequest.getCreatedAt());
        response.setUpdatedAt(bloodRequest.getUpdatedAt());

        return response;
    }
}