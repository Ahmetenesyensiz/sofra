package com.example.sofra_backend.service;

import com.example.sofra_backend.model.CallRequest;
import com.example.sofra_backend.repository.CallRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CallRequestService {

    private final CallRequestRepository callRequestRepository;

    public List<CallRequest> getAllCallRequests() {
        log.info("Fetching all call requests");
        return callRequestRepository.findAll();
    }

    public Optional<CallRequest> getCallRequestById(String id) {
        log.info("Fetching call request with ID: {}", id);
        return callRequestRepository.findById(id);
    }

    public List<CallRequest> getCallRequestsByRestaurant(String restaurantId) {
        log.info("Fetching call requests for restaurant ID: {}", restaurantId);
        return callRequestRepository.findByRestaurantId(restaurantId);
    }

    public List<CallRequest> getCallRequestsByTable(String tableId) {
        log.info("Fetching call requests for table ID: {}", tableId);
        return callRequestRepository.findByTableId(tableId);
    }

    public CallRequest createCallRequest(CallRequest callRequest) {
        log.info("Creating new call request: {}", callRequest);
        return callRequestRepository.save(callRequest);
    }

    public void deleteCallRequest(String id) {
        log.info("Deleting call request with ID: {}", id);
        callRequestRepository.deleteById(id);
    }
}
