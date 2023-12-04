package com.alinanails.project.service;

import com.alinanails.project.model.ApiService;
import com.alinanails.project.repository.ApiServiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApiServiceLogic {

    private final ApiServiceRepository apiServiceRepository;


    public ApiServiceLogic(ApiServiceRepository apiServiceRepository) {
        this.apiServiceRepository = apiServiceRepository;
    }

    public ApiService getServiceById(Long id){
        return apiServiceRepository.findById(id)
                    .filter(apiService ->
                            apiService.getServiceId().equals(id))
                    .orElseThrow(()-> new IllegalStateException("No such a service found by " + id));
    }

    public Iterable<ApiService> getAllServices(Long id){
        return apiServiceRepository.findAll();
    }

    public ApiService createNewService(ApiService apiService){
        return apiServiceRepository.save(apiService);
    }

    public void deleteServiceById(Long id){
        apiServiceRepository.deleteById(id);
    }

    public Optional<ApiService> modifyServiceById(Long id, ApiService apiService){

      return apiServiceRepository.findById(id)
              .filter(service->service.getServiceId().equals(id))
              .map(serv ->{
                  serv.setServiceName(apiService.getServiceName());
                  serv.setServicePrice(apiService.getServicePrice());
                  serv.setDurationInMinutes(apiService.getDurationInMinutes());
                  serv.setServiceDescription(apiService.getServiceDescription());
                  return apiServiceRepository.save(serv);
              });


    }
}
