package com.NextGenPay.service;
import com.NextGenPay.data.model.Customer;
import com.NextGenPay.data.model.CustomerProfile;
import com.NextGenPay.data.repository.CustomerProfileRepo;
import com.NextGenPay.data.repository.CustomerRepo;
import com.NextGenPay.exception.CustomerNotFoundException;
import com.NextGenPay.exception.UserNameAlreadyExistException;
import com.NextGenPay.dto.request.CreateProfileRequest;
import com.NextGenPay.dto.response.CreateProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService{
    @Autowired
    private CustomerProfileRepo customerProfileRepo;

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public CreateProfileResponse createProfile(CreateProfileRequest createProfileRequest) {
        Customer foundCustomer = customerRepo.findCustomerByCustomerId(createProfileRequest.getCustomerId());

        if(foundCustomer == null){throw new CustomerNotFoundException("Customer not found");}
        if(customerProfileRepo.existsByUserName(createProfileRequest.getUserName())){throw new UserNameAlreadyExistException("Username already exist, please try another");}

        CustomerProfile customerProfile = setCustomerProfile(createProfileRequest, foundCustomer);

        CustomerProfile savedProfile = customerProfileRepo.save(customerProfile);

        foundCustomer.setProfileId(savedProfile.getId());
        customerRepo.save(foundCustomer);

        String message = "Profile created successfully";
        return new CreateProfileResponse(message, savedProfile.getId(), savedProfile.getUserName());
    }

    @Override
    public CreateProfileResponse updateProfile(CreateProfileRequest createProfileRequest) {
        Customer newFoundCustomer = customerRepo.findCustomerByCustomerId(createProfileRequest.getCustomerId());

        if(newFoundCustomer == null){throw new CustomerNotFoundException("Customer not found");}
        if(customerProfileRepo.existsByUserName(createProfileRequest.getUserName())){throw new UserNameAlreadyExistException("Username already exist, please try another");}

        CustomerProfile customerProfile = setCustomerProfile(createProfileRequest, newFoundCustomer);

        CustomerProfile savedProfile = customerProfileRepo.save(customerProfile);

        newFoundCustomer.setProfileId(savedProfile.getId());
        customerRepo.save(newFoundCustomer);

        String message = "Profile updated successfully";
        return new CreateProfileResponse(message, savedProfile.getId(), savedProfile.getUserName());
    }

    private static CustomerProfile setCustomerProfile(CreateProfileRequest createProfileRequest, Customer newFoundCustomer) {
        CustomerProfile customerProfile = new CustomerProfile();

        customerProfile.setProfileImage(createProfileRequest.getProfileImage());
        customerProfile.setAddress(createProfileRequest.getAddress());
        customerProfile.setDateOfBirth(createProfileRequest.getDateOfBirth());
        customerProfile.setFirstName(createProfileRequest.getFirstName());
        customerProfile.setLastName(createProfileRequest.getLastName());
        customerProfile.setUserName(createProfileRequest.getUserName());
        customerProfile.setCustomerId(newFoundCustomer.getCustomerId());
        return customerProfile;
    }
}
