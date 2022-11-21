package com.ecommerce.api.apiecommerce.Services;

import com.ecommerce.api.apiecommerce.Models.PedidoModels;
import com.ecommerce.api.apiecommerce.Repositories.PedidoRepositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
public class PedidoServices {
    final PedidoRepositories pedidoRepositories;

    public PedidoServices(PedidoRepositories pedidoRepositories) {
        this.pedidoRepositories = pedidoRepositories;
    }

    @Transactional
    public PedidoModels save(PedidoModels pedidoModels){
        return pedidoRepositories.save(pedidoModels);
    }

    public Optional<PedidoModels> findById(long id) {
        return pedidoRepositories.findById(id);
    }

    public Page<PedidoModels> findAll(Pageable pageable) { return pedidoRepositories.findAll(pageable); }
}
