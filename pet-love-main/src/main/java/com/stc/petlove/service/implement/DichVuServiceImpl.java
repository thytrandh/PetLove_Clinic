package com.stc.petlove.service.implement;

import com.stc.petlove.entities.DatCho;
import com.stc.petlove.entities.DichVu;
import com.stc.petlove.entities.embedded.GiaDichVu;
import com.stc.petlove.entities.embedded.ThongTinDatCho;
import com.stc.petlove.exceptions.NotFoundException;
import com.stc.petlove.repository.DichVuRepository;
import com.stc.petlove.service.IDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DichVuServiceImpl implements IDichVuService {

    @Autowired
    private DichVuRepository dichVuRepository;


    @Override
    public DichVu addGiaDichVu(String id, GiaDichVu giaDichVu) {
        Optional<DichVu> dichVu=dichVuRepository.findById(id);
        if(dichVu==null){
            throw new NotFoundException(String.format("Id  %s không tồn tại",id));
        }
        dichVu.get().getGiaDichVus().add(giaDichVu);
        return dichVuRepository.save(dichVu.get());

    }

    @Override
    public DichVu addDichVu(DichVu dichVu) {
        DichVu dichVu1=new DichVu();
        if(dichVu!=null){
            dichVu1.setMaDichVu(dichVu.getMaDichVu());
            dichVu1.setTenDichVu(dichVu.getTenDichVu());
            dichVu1.setNoiDung(dichVu.getNoiDung());
            dichVu1.setGiaDichVus(dichVu.getGiaDichVus());
            dichVu1.setTrangThai(true);
            return dichVuRepository.save(dichVu1);
        }
        return null;
    }

    @Override
    public DichVu updateDichVu(String id, DichVu dichVu) {
        if(dichVu!=null)
        {
            DichVu dichVu1 = dichVuRepository.findById(id).get();
            if(dichVu1!=null){
                dichVu1.setMaDichVu(dichVu.getMaDichVu());
                dichVu1.setTenDichVu(dichVu.getTenDichVu());
                dichVu1.setNoiDung(dichVu.getNoiDung());
                dichVu1.setGiaDichVus(dichVu.getGiaDichVus());
                dichVu1.setTrangThai(true);
                return dichVuRepository.save(dichVu1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteDichVu(String id) {

        DichVu dichVu=dichVuRepository.findById(id).get();
        if(dichVu!=null){
            dichVuRepository.delete(dichVu);
            return true;
        }

        return false;
    }

    @Override
    public List<DichVu> getAllDichVu() {
        return dichVuRepository.findAll();
    }
}
