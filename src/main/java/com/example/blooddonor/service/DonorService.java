package com.example.blooddonor.service;

import com.example.blooddonor.dto.DonorRequest;
import com.example.blooddonor.entity.Donor;
import com.example.blooddonor.entity.DonorStatus;
import com.example.blooddonor.repository.DonorRepository;
import org.springframework.stereotype.Service;
import com.example.blooddonor.exception.DonorNotFoundException;

import java.util.List;

@Service
public class DonorService {

    private final DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    public Donor createDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Donor getDonorById(Long id) {
        return donorRepository.findById(id)
                .orElseThrow(() -> new DonorNotFoundException(id));
    }
    public Donor updateDonor(Long id, DonorRequest.DonorUpdateRequest request) {

        Donor donor = getDonorById(id);

        donor.setPhone(request.getPhone());
        donor.setEmail(request.getEmail());
        donor.setAddress(request.getAddress());
        donor.setLandmark(request.getLandmark());
        donor.setLatitude(request.getLatitude());
        donor.setLongitude(request.getLongitude());
        donor.setSearchRadiusKm(request.getSearchRadiusKm());
        donor.setDonationFrequencyDays(request.getDonationFrequencyDays());
        donor.setLastDonationDate(request.getLastDonationDate());

        return donorRepository.save(donor);
    }
    public Donor updateDonorStatus(Long id, DonorStatus status) {
        Donor donor = getDonorById(id);

        donor.setStatus(status);

        return donorRepository.save(donor);
    }
}
