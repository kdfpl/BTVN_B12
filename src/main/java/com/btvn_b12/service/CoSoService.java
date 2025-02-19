package com.btvn_b12.service;

import com.btvn_b12.entity.CoSo;
import com.btvn_b12.repository.CoSoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoSoService {
    private final CoSoRepository coSoRepository;

    public CoSoService(CoSoRepository coSoRepository) {
        this.coSoRepository = coSoRepository;
    }

    public List<CoSo> getAllCoSos() {
        return coSoRepository.findAll();
    }

    public void addOrUpdate(CoSo coSo) {
        coSoRepository.save(coSo);
    }

    public CoSo findById(Integer id) {
        return coSoRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        coSoRepository.deleteById(id);
    }
}
