package com.btvn_b12.service;

import com.btvn_b12.entity.TaiKhoanNganHang;
import com.btvn_b12.repository.TaiKhoanNganHangRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaiKhoanNganHangService {

    private final TaiKhoanNganHangRepository taiKhoanNganHangRepository;

    public TaiKhoanNganHangService(TaiKhoanNganHangRepository taiKhoanNganHangRepository) {
        this.taiKhoanNganHangRepository = taiKhoanNganHangRepository;
    }

    public List<TaiKhoanNganHang> findAll() {
        return taiKhoanNganHangRepository.findAll();
    }
}
