package be.springPressOrder.services;

import be.springPressOrder.dao.JuiceRepository;
import be.springPressOrder.dao.OrderRepository;
import be.springPressOrder.domain.Juice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JuiceService implements JuiceServiceInt {

    private JuiceRepository juiceRepository;

    @Autowired
    public void setOrderRepository(JuiceRepository juiceRepository) {
        this.juiceRepository = juiceRepository;
    }

    public Iterable<Juice> listAllJuices() {
        return juiceRepository.findAll();
    }
}

