package com.alinanails.project.repository;

import com.alinanails.project.model.ApiService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiServiceRepository extends CrudRepository<ApiService, Long> {
}
