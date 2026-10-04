package com.example.blooddonor.dto;

public class BloodRequestMatchingResponse {

    private Long bloodRequestId;

    private Integer matchedDonorCount;

    public BloodRequestMatchingResponse() {
    }

    public BloodRequestMatchingResponse(
            Long bloodRequestId,
            Integer matchedDonorCount) {

        this.bloodRequestId = bloodRequestId;
        this.matchedDonorCount = matchedDonorCount;
    }

    public Long getBloodRequestId() {
        return bloodRequestId;
    }

    public void setBloodRequestId(Long bloodRequestId) {
        this.bloodRequestId = bloodRequestId;
    }

    public Integer getMatchedDonorCount() {
        return matchedDonorCount;
    }

    public void setMatchedDonorCount(Integer matchedDonorCount) {
        this.matchedDonorCount = matchedDonorCount;
    }
}