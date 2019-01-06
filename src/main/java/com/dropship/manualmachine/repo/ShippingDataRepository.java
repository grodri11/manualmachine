package com.dropship.manualmachine.repo;

import com.dropship.manualmachine.models.ShippingModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingDataRepository extends CrudRepository<ShippingModel, Long>{
}
