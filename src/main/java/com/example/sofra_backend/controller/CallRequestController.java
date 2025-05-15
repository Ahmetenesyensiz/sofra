package com.example.sofra_backend.controller;

import com.example.sofra_backend.model.CallRequest;
import com.example.sofra_backend.service.CallRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/callRequests")
@RequiredArgsConstructor
public class CallRequestController {

    private final CallRequestService callRequestService;

    @GetMapping
    public List<CallRequest> getAllCallRequests() {
        return callRequestService.getAllCallRequests();
    }

    @GetMapping("/{id}")
    public Optional<CallRequest> getCallRequestById(@PathVariable String id) {
        return callRequestService.getCallRequestById(id);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<CallRequest> getCallRequestsByRestaurant(@PathVariable String restaurantId) {
        return callRequestService.getCallRequestsByRestaurant(restaurantId);
    }

    @GetMapping("/table/{tableId}")
    public List<CallRequest> getCallRequestsByTable(@PathVariable String tableId) {
        return callRequestService.getCallRequestsByTable(tableId);
    }

    @PostMapping
    public CallRequest createCallRequest(@RequestBody CallRequest callRequest) {
        return callRequestService.createCallRequest(callRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCallRequest(@PathVariable String id) {
        callRequestService.deleteCallRequest(id);
    }
}
