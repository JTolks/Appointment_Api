package com.alinanails.project.repository;

import com.alinanails.project.model.Master;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends CrudRepository<Master,Long> {
}
