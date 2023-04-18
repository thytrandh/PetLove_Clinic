package com.stc.petlove.service;

import com.stc.petlove.entities.DatCho;
import com.stc.petlove.entities.DichVu;
import com.stc.petlove.entities.embedded.GiaDichVu;

import java.util.List;

public interface IDichVuService {

    DichVu addGiaDichVu(String id, GiaDichVu giaDichVu);

    public DichVu addDichVu(DichVu dichVu);

    public DichVu updateDichVu(String id, DichVu dichVu);

    public boolean deleteDichVu(String id);

    public List<DichVu> getAllDichVu();

}
