package com.example.blooddonor.entity;
import com.example.blooddonor.entity.DonorStatus;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "blood_request_donors",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_blood_request_donor",
                        columnNames = {"blood_request_id", "donor_id"}
                )
        },
        indexes = {
                @Index(
                        name = "idx_brd_blood_request",
                        columnList = "blood_request_id"
                ),
                @Index(
                        name = "idx_brd_donor",
                        columnList = "donor_id"
                ),
                @Index(
                        name = "idx_brd_request_status",
                        columnList = "blood_request_id, status"
                )
        }
)
public class BloodRequestDonor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "blood_request_id", nullable = false)
    private Long bloodRequestId;

    @Column(name = "donor_id", nullable = false)
    private Long donorId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private BloodRequestDonorStatus status =
            BloodRequestDonorStatus.NOTIFIED;

    @Column(name = "notification_count", nullable = false)
    private Integer notificationCount = 1;

    @Column(name = "last_notified_at", nullable = false)
    private LocalDateTime lastNotifiedAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {

        LocalDateTime now = LocalDateTime.now();

        createdAt = now;
        updatedAt = now;

        if (status == null) {
            status = BloodRequestDonorStatus.NOTIFIED;
        }

        if (notificationCount == null) {
            notificationCount = 1;
        }

        if (lastNotifiedAt == null) {
            lastNotifiedAt = now;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}