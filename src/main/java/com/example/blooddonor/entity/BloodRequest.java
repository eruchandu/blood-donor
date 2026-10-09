package com.example.blooddonor.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "blood_requests",
        indexes = {
                @Index(name = "idx_blood_request_status", columnList = "status"),
                @Index(name = "idx_blood_request_blood_group", columnList = "blood_group"),
                @Index(name = "idx_blood_request_requestor", columnList = "requestor_id")
        }
)
public class BloodRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Temporary requestor identifier.
     *
     * Later this will be connected to the application's
     * authenticated user/account system.
     */
    @Column(name = "requestor_id", nullable = false)
    private Long requestorId;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group", nullable = false, length = 20)
    private BloodGroup bloodGroup;

    @Column(name = "required_units", nullable = false)
    private Integer requiredUnits;

    @Column(name = "completed_units", nullable = false)
    private Integer completedUnits = 0;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String address;

    @Column(length = 255)
    private String landmark;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(name = "search_radius_km", nullable = false)
    private Double searchRadiusKm = 5.0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private BloodRequestStatus status = BloodRequestStatus.OPEN;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;

        if (completedUnits == null) {
            completedUnits = 0;
        }

        if (searchRadiusKm == null) {
            searchRadiusKm = 5.0;
        }

        if (status == null) {
            status = BloodRequestStatus.OPEN;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getRequestorId() {
        return requestorId;
    }

    public void setRequestorId(Long requestorId) {
        this.requestorId = requestorId;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Integer getRequiredUnits() {
        return requiredUnits;
    }

    public void setRequiredUnits(Integer requiredUnits) {
        this.requiredUnits = requiredUnits;
    }

    public Integer getCompletedUnits() {
        return completedUnits;
    }

    public void setCompletedUnits(Integer completedUnits) {
        this.completedUnits = completedUnits;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getSearchRadiusKm() {
        return searchRadiusKm;
    }

    public void setSearchRadiusKm(Double searchRadiusKm) {
        this.searchRadiusKm = searchRadiusKm;
    }

    public BloodRequestStatus getStatus() {
        return status;
    }

    public void setStatus(BloodRequestStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}