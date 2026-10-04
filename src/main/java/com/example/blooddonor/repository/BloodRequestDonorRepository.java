package com.example.blooddonor.repository;

import com.example.blooddonor.entity.BloodRequestDonor;
import com.example.blooddonor.entity.BloodRequestDonorStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BloodRequestDonorRepository
        extends JpaRepository<BloodRequestDonor, Long> {

    List<BloodRequestDonor> findByBloodRequestId(Long bloodRequestId);

    List<BloodRequestDonor> findByDonorId(Long donorId);

    List<BloodRequestDonor> findByBloodRequestIdAndStatus(
            Long bloodRequestId,
            BloodRequestDonorStatus status
    );

    boolean existsByBloodRequestIdAndDonorId(
            Long bloodRequestId,
            Long donorId
    );
    Optional<BloodRequestDonor> findByIdAndDonorId(
            Long id,
            Long donorId
    );
}