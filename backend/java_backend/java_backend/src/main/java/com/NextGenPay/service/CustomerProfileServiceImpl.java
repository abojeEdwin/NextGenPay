package com.NextGenPay.service;
import com.NextGenPay.data.model.CustomerProfile;
import com.NextGenPay.data.repository.CustomerProfileRepo;
import com.NextGenPay.dto.request.CreateProfileRequest;
import com.NextGenPay.dto.response.CreateProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService{

    @Autowired
    private CustomerProfileRepo customerProfileRepo;


    @Override
    public CreateProfileResponse createProfile(CreateProfileRequest createProfileRequest) {

        CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setProfileImage(createProfileRequest.getProfileImage());
        customerProfile.setAddress(createProfileRequest.getAddress());
        customerProfile.setDateOfBirth(createProfileRequest.getDateOfBirth());
        customerProfile.setFirstName(createProfileRequest.getFirstName());
        customerProfile.setLastName(createProfileRequest.getLastName());
        customerProfile.setUserName(createProfileRequest.getUserName());
        CustomerProfile savedProfile = customerProfileRepo.save(customerProfile);

        String message = "Profile created successfully";
        return new CreateProfileResponse(message, savedProfile.getId(), savedProfile.getUserName());
    }
}
