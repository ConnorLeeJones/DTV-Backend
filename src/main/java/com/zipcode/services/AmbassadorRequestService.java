package com.zipcode.services;

import com.zipcode.models.AmbassadorRequest;
import com.zipcode.repositories.AmbassadorRepo;
import com.zipcode.repositories.AmbassadorRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmbassadorRequestService {

    private AmbassadorRequestRepo ambassadorRequestRepo;
    private AmbassadorRepo ambassadorRepo;

    @Autowired
    public AmbassadorRequestService(AmbassadorRequestRepo ambassadorRequestRepo, AmbassadorRepo ambassadorRepo) {
        this.ambassadorRequestRepo = ambassadorRequestRepo;
        this.ambassadorRepo = ambassadorRepo;
    }

    // POST
    public AmbassadorRequest createRequest(AmbassadorRequest ambassadorRequest) {
        return ambassadorRequestRepo.save(ambassadorRequest);
    }

    // GET

    public Iterable<AmbassadorRequest> findAllRequests() {
        return ambassadorRequestRepo.findAll();
    }

    public AmbassadorRequest findRequestById(Long requestId) {
        AmbassadorRequest request = ambassadorRequestRepo.findById(requestId).get();
        return request;
    }

    public Iterable<AmbassadorRequest> findRequestsByAmbassadorId(Long ambassadorId) {
        Iterable<AmbassadorRequest> requests = ambassadorRequestRepo.findAmbassadorRequestsByAmbassadorId(ambassadorId);
return requests;
    }

    public Iterable<AmbassadorRequest> findAllRequestsByFirstName(String firstName) {
        Iterable<AmbassadorRequest> requests = ambassadorRequestRepo.findAmbassadorRequestsByFirstName(firstName);
        return requests;
    }

    public Iterable<AmbassadorRequest> findAllRequestsByLastName(String lastName) {
        Iterable<AmbassadorRequest> requests = ambassadorRequestRepo.findAmbassadorRequestsByLastName(lastName);
        return requests;
    }

    // UPDATE
    public void updateFirstName(AmbassadorRequest request, String newFirstName) {
        request.setFirstName(newFirstName);
        ambassadorRequestRepo.save(request);
    }

    public void updateLastName(AmbassadorRequest request, String newLastName) {
        request.setLastName(newLastName);
        ambassadorRequestRepo.save(request);
    }
    public void updatePhoneNumber(AmbassadorRequest request, String newPhoneNumber) {
        request.setPhoneNumber(newPhoneNumber);
        ambassadorRequestRepo.save(request);
    }

    public void updatePickUpLocation(AmbassadorRequest request, String newPickUpLocation) {
        request.setPickUpLocation(newPickUpLocation);
        ambassadorRequestRepo.save(request);
    }

    public void updateDropOffLocation(AmbassadorRequest request, String newDropOffLocation) {
        request.setDropOffLocation(newDropOffLocation);
        ambassadorRequestRepo.save(request);
    }

    public void updateAmbassadorId(AmbassadorRequest request, Long newAmbassadorId) {
        request.setAmbassadorId(newAmbassadorId);
        ambassadorRequestRepo.save(request);
    }

    // DELETE
    public void deleteRequest(Long requestId) {
            ambassadorRequestRepo.deleteById(requestId);
    }


}