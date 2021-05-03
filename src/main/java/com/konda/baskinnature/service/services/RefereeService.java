package com.konda.baskinnature.service.services;

import com.konda.baskinnature.model.Referee;

import java.util.List;

public interface RefereeService {
    Referee addRefree(Referee referee);
    Referee updateRefree(Referee referee, String id);
    String deleteRefree(String id);
    Referee getRefree(String code);
    List<Referee> getRefrees();
}
