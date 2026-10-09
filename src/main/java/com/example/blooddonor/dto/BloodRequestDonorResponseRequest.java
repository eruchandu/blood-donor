package com.example.blooddonor.dto;

import com.example.blooddonor.entity.BloodRequestDonorStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BloodRequestDonorResponseRequest {

    @NotNull(message = "Status is required")
    private BloodRequestDonorStatus status;

    @Positive(message = "Offered units must be greater than zero")
    private Integer offeredUnits;

    public BloodRequestDonorStatus getStatus() {
        return status;
    }

    public void setStatus(BloodRequestDonorStatus status) {
        this.status = status;
    }

    public Integer getOfferedUnits() {
        return offeredUnits;
    }

    public void setOfferedUnits(Integer offeredUnits) {
        this.offeredUnits = offeredUnits;
    }
}