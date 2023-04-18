package com.stc.petlove.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 4/11/23
 * Time      : 10:01 PM
 * Filename  : LoaiThuCung
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "loai-thu-cung")
public class LoaiThuCung {
    @Id
    private String id;

    // mã không được trùng
    @Indexed(unique = true)
    private String maLoaiThuCung;

    private String tenLoaiThuCung;

    private boolean trangThai = true;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaLoaiThuCung() {
        return maLoaiThuCung;
    }

    public void setMaLoaiThuCung(String maLoaiThuCung) {
        this.maLoaiThuCung = maLoaiThuCung;
    }

    public String getTenLoaiThuCung() {
        return tenLoaiThuCung;
    }

    public void setTenLoaiThuCung(String tenLoaiThuCung) {
        this.tenLoaiThuCung = tenLoaiThuCung;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
