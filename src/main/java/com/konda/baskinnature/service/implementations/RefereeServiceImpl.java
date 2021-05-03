package com.konda.baskinnature.service.implementations;

import com.konda.baskinnature.model.Referee;
import com.konda.baskinnature.repository.RefereeRepository;
import com.konda.baskinnature.service.services.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefereeServiceImpl implements RefereeService {
    @Autowired
    RefereeRepository refereeRepository;

    @Override
    public Referee addRefree(Referee referee) {
        return refereeRepository.insert(referee);
    }

    @Override
    public Referee updateRefree(Referee referee, String id) {
        Referee oldReferee = refereeRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        oldReferee.setId(referee.getId());
        oldReferee.setName(referee.getName());
        oldReferee.setEmail(referee.getEmail());
        oldReferee.setPercentage(referee.getPercentage());
        oldReferee.setOrders(referee.getOrders());
        oldReferee.setTotalSales(referee.getTotalSales());
        return refereeRepository.save(oldReferee);
    }

    @Override
    public String deleteRefree(String id) {
        refereeRepository.deleteById(id);
        return "referee deleted successfully";
    }

    @Override
    public Referee getRefree(String code) {
        return refereeRepository.findById(code).orElseThrow(() -> new RuntimeException("Invalid Code"));
    }

    @Override
    public List<Referee> getRefrees() {
        return refereeRepository.findAll();
    }
}
