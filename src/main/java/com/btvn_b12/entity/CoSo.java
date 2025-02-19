package com.btvn_b12.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "co_so")
public class CoSo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tai_khoan_ngan_hang_id")
    private TaiKhoanNganHang taiKhoanNganHang;

    @Column(name = "ma", nullable = false, length = 20)
    @NotBlank(message = "Ma co so khong duoc de trong")
    private String ma;

    @Nationalized
    @Column(name = "ten_co_so", length = 50)
    private String tenCoSo;

    @Nationalized
    @Column(name = "ho_ten_nguoi_dai_dien", length = 50)
    private String hoTenNguoiDaiDien;

    @Column(name = "ma_so_thue", length = 20)
    private String maSoThue;

    @Column(name = "so_dien_thoai", length = 20)
    @NotBlank(message = "So dien thoai khong duoc de trong")
    private String soDienThoai;

    @Column(name = "email", length = 50)
    private String email;

    @Nationalized
    @Column(name = "ghi_chu", length = 100)
    @NotBlank(message = "Ghi chu khong duoc de trong")
    private String ghiChu;

    @Nationalized
    @Column(name = "ten_tinh", length = 50)
    private String tenTinh;

    @Nationalized
    @Column(name = "ten_thanh_pho", length = 50)
    private String tenThanhPho;

    @Nationalized
    @Column(name = "ten_quan_huyen", length = 50)
    private String tenQuanHuyen;

    @ColumnDefault("1")
    @Column(name = "trang_thai")
    private Integer trangThai;

    @ColumnDefault("getdate()")
    @Column(name = "ngay_tao")
    private LocalDate ngayTao;

    @ColumnDefault("getdate()")
    @Column(name = "ngay_chinh_sua")
    private LocalDate ngayChinhSua;

}