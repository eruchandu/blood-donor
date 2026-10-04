package com.example.blooddonor.dto;

import com.example.blooddonor.entity.BloodRequestDonorStatus;
import jakarta.validation.constraints.NotNull;

public class BloodRequestDonorStatusUpdateRequest {

    @NotNull(message = "Status is required")
    private BloodRequestDonorStatus status;

    public BloodRequestDonorStatus getStatus() {
        return status;
    }

    public void setStatus(BloodRequestDonorStatus status) {
        this.status = status;
    }
}