package com.example.blooddonor.dto;

import com.example.blooddonor.entity.BloodGroup;
import com.example.blooddonor.entity.DonorStatus;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class DonorRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone is required")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone must contain exactly 10 digits"
    )
    private String phone;

    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Blood group is required")
    private BloodGroup bloodGroup;

    @NotBlank(message = "Address is required")
    private String address;

    private String landmark;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
    private Double longitude;

    @NotNull(message = "Search radius is required")
    @Positive(message = "Search radius must be greater than 0")
    private Double searchRadiusKm;

    @NotNull(message = "Donation frequency is required")
    @Min(value = 1, message = "Donation frequency must be at least 1 day")
    @Max(value = 365, message = "Donation frequency cannot exceed 365 days")
    private Integer donationFrequencyDays;

    private LocalDate lastDonationDate;
    private DonorStatus status = DonorStatus.ACTIVE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
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

    public Integer getDonationFrequencyDays() {
        return donationFrequencyDays;
    }

    public void setDonationFrequencyDays(Integer donationFrequencyDays) {
        this.donationFrequencyDays = donationFrequencyDays;
    }

    public LocalDate getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(LocalDate lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }

    public static class DonorUpdateRequest {

        @NotBlank(message = "Phone is required")
        @Pattern(
                regexp = "^[0-9]{10}$",
                message = "Phone must contain exactly 10 digits"
        )
        private String phone;

        @Email(message = "Email must be valid")
        private String email;

        @NotBlank(message = "Address is required")
        private String address;

        private String landmark;

        @NotNull(message = "Latitude is required")
        @DecimalMin(value = "-90.0", message = "Latitude must be between -90 and 90")
        @DecimalMax(value = "90.0", message = "Latitude must be between -90 and 90")
        private Double latitude;

        @NotNull(message = "Longitude is required")
        @DecimalMin(value = "-180.0", message = "Longitude must be between -180 and 180")
        @DecimalMax(value = "180.0", message = "Longitude must be between -180 and 180")
        private Double longitude;

        @NotNull(message = "Search radius is required")
        @Positive(message = "Search radius must be greater than 0")
        private Double searchRadiusKm;

        @NotNull(message = "Donation frequency is required")
        @Min(value = 1, message = "Donation frequency must be at least 1 day")
        @Max(value = 365, message = "Donation frequency cannot exceed 365 days")
        private Integer donationFrequencyDays;

        private LocalDate lastDonationDate;

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setLandmark(String landmark) {
            this.landmark = landmark;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public void setSearchRadiusKm(Double searchRadiusKm) {
            this.searchRadiusKm = searchRadiusKm;
        }

        public void setLastDonationDate(LocalDate lastDonationDate) {
            this.lastDonationDate = lastDonationDate;
        }

        public void setAvailable(Boolean available) {
            this.available = available;
        }

        public void setDonationFrequencyDays(Integer donationFrequencyDays) {
            this.donationFrequencyDays = donationFrequencyDays;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }

        public String getAddress() {
            return address;
        }

        public Double getLatitude() {
            return latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public Integer getDonationFrequencyDays() {
            return donationFrequencyDays;
        }

        public Double getSearchRadiusKm() {
            return searchRadiusKm;
        }

        public LocalDate getLastDonationDate() {
            return lastDonationDate;
        }

        public Boolean getAvailable() {
            return available;
        }

        public String getLandmark() {
            return landmark;
        }

        private Boolean available;

        // Generate getters and setters for all fields
    }
}