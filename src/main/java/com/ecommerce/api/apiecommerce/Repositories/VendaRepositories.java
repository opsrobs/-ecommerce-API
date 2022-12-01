package com.ecommerce.api.apiecommerce.Repositories;

import com.ecommerce.api.apiecommerce.Models.PedidoModels;
import com.ecommerce.api.apiecommerce.Models.VendaModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepositories extends JpaRepository <VendaModels, Long>{

    VendaModels findByPaypalOrderId(String paypalOrderId);
}
