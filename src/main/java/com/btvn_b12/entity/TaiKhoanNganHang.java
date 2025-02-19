package com.btvn_b12.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tai_khoan_ngan_hang")
public class TaiKhoanNganHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ma", nullable = false, length = 20)
    private String ma;

    @Column(name = "ho_ten_chu_tai_khoan", length = 50)
    private String hoTenChuTaiKhoan;

    @Column(name = "so_tai_khoan", length = 50)
    private String soTaiKhoan;

    @Nationalized
    @Column(name = "ten_ngan_hang", length = 50)
    private String tenNganHang;

    @Nationalized
    @Column(name = "ten_chi_nhanh", length = 50)
    private String tenChiNhanh;

    @Nationalized
    @Column(name = "dia_chi", length = 50)
    private String diaChi;

    @Nationalized
    @Column(name = "ghi_chu", length = 50)
    private String ghiChu;

    @ColumnDefault("1")
    @Column(name = "trang_thai")
    private Integer trangThai;

    @ColumnDefault("getdate()")
    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @ColumnDefault("getdate()")
    @Column(name = "ngay_sua")
    private LocalDate ngaySua;

}