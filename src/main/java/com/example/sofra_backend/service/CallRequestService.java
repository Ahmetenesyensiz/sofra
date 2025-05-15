package com.example.sofra_backend.service;

import com.example.sofra_backend.model.CallRequest;
import com.example.sofra_backend.repository.CallRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CallRequestService {

    private final CallRequestRepository callRequestRepository;

    public List<CallRequest> getAllCallRequests() {
        return callRequestRepository.findAll();
    }

    public Optional<CallRequest> getCallRequestById(String id) {
        return callRequestRepository.findById(id);
    }

    public List<CallRequest> getCallRequestsByRestaurant(String restaurantId) {
        return callRequestRepository.findByRestaurantId(restaurantId);
    }

    public List<CallRequest> getCallRequestsByTable(String tableId) {
        return callRequestRepository.findByTableId(tableId);
    }

    public CallRequest createCallRequest(CallRequest callRequest) {
        return callRequestRepository.save(callRequest);
    }

    public void deleteCallRequest(String id) {
        callRequestRepository.deleteById(id);
    }
}
