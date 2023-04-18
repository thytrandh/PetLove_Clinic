package com.stc.petlove.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stc.petlove.entities.embedded.ThongTinDatCho;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 4/11/23
 * Time      : 9:37 PM
 * Filename  : DatCho
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dat-cho")
public class DatCho {
    @Id
    private String id;

    // email người đặt chỗ
    private String email;

    private List<ThongTinDatCho> thongTinDatChos = new ArrayList<>();

    // Thời gian chăm sóc thú cưng
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date thoiGian;

    // căn dặn khi chăm sóc thú cưng
    private String canDan;

    // lấy từ enum trạng thái đặt chỗ
    private String trangThaiDatCho;

    private boolean trangThai = true;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ThongTinDatCho> getThongTinDatChos() {
        return thongTinDatChos;
    }

    public void setThongTinDatChos(List<ThongTinDatCho> thongTinDatChos) {
        this.thongTinDatChos = thongTinDatChos;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getCanDan() {
        return canDan;
    }

    public void setCanDan(String canDan) {
        this.canDan = canDan;
    }

    public String getTrangThaiDatCho() {
        return trangThaiDatCho;
    }

    public void setTrangThaiDatCho(String trangThaiDatCho) {
        this.trangThaiDatCho = trangThaiDatCho;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
