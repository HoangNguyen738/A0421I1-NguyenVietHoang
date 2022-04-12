package com.codegym.casestudy.repository.customer;

import com.codegym.casestudy.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
