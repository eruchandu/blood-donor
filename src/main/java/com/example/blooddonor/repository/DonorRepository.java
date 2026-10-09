package com.example.blooddonor.repository;

import com.example.blooddonor.entity.BloodGroup;
import com.example.blooddonor.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {

    @Query(value = """
            SELECT d.*
            FROM donors d
            WHERE d.blood_group = :bloodGroup
              AND d.status = 'ACTIVE'
              AND (
                    d.last_donation_date IS NULL
                    OR d.last_donation_date <=
                       CURRENT_DATE -
                       (d.donation_frequency_days * INTERVAL '1 day')
                  )
              AND ST_DWithin(
                    ST_SetSRID(
                        ST_MakePoint(d.longitude, d.latitude),
                        4326
                    )::geography,
                    ST_SetSRID(
                        ST_MakePoint(:longitude, :latitude),
                        4326
                    )::geography,
                    (:radiusKm * 1000)
                  )
              AND NOT EXISTS (
                    SELECT 1
                    FROM blood_request_donors brd
                    WHERE brd.blood_request_id = :bloodRequestId
                      AND brd.donor_id = d.id
                  )
            """, nativeQuery = true)
    List<Donor> findEligibleDonors(
            @Param("bloodRequestId") Long bloodRequestId,
            @Param("bloodGroup") String bloodGroup,
            @Param("latitude") Double latitude,
            @Param("longitude") Double longitude,
            @Param("radiusKm") Double radiusKm
    );
}