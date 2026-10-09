package com.example.blooddonor.dto;

import com.example.blooddonor.entity.BloodRequestDonorStatus;

import java.time.LocalDateTime;

public class BloodRequestDonorResponse {

    private Long id;
    private Long bloodRequestId;
    private Long donorId;
    private BloodRequestDonorStatus status;
    private Integer notificationCount;
    private LocalDateTime lastNotifiedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer offeredUnits;

    public Integer getOfferedUnits() {
        return offeredUnits;
    }

    public void setOfferedUnits(Integer offeredUnits) {
        this.offeredUnits = offeredUnits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBloodRequestId() {
        return bloodRequestId;
    }

    public void setBloodRequestId(Long bloodRequestId) {
        this.bloodRequestId = bloodRequestId;
    }

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public BloodRequestDonorStatus getStatus() {
        return status;
    }

    public void setStatus(BloodRequestDonorStatus status) {
        this.status = status;
    }

    public Integer getNotificationCount() {
        return notificationCount;
    }

    public void setNotificationCount(Integer notificationCount) {
        this.notificationCount = notificationCount;
    }

    public LocalDateTime getLastNotifiedAt() {
        return lastNotifiedAt;
    }

    public void setLastNotifiedAt(LocalDateTime lastNotifiedAt) {
        this.lastNotifiedAt = lastNotifiedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}