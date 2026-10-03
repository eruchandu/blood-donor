package com.example.blooddonor.dto;

import com.example.blooddonor.entity.DonorStatus;
import jakarta.validation.constraints.NotNull;

public class DonorStatusUpdateRequest {

    @NotNull(message = "Status is required")
    private DonorStatus status;

    public DonorStatus getStatus() {
        return status;
    }

    public void setStatus(DonorStatus status) {
        this.status = status;
    }
}