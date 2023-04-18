package com.stc.petlove.service.implement;

import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.repository.TaiKhoanRepository;
import com.stc.petlove.service.ITaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaiKhoanServiceImpl implements ITaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;


    @Override
    public TaiKhoan addTaiKhoan(TaiKhoan taiKhoan) {
        if (taiKhoan!=null){
            return taiKhoanRepository.save(taiKhoan);
        }
        return null;
    }

    @Override
    public TaiKhoan updateTaiKhoan(String id, TaiKhoan taiKhoan) {
        if(taiKhoan!=null){
            TaiKhoan taiKhoan1=taiKhoanRepository.findById(id).get();
            if(taiKhoan1!=null){
                taiKhoan1.setName(taiKhoan.getName());
                taiKhoan1.setEmail(taiKhoan.getEmail());
                taiKhoan1.setPassword(taiKhoan1.getPassword());
                taiKhoan1.setDienThoai(taiKhoan.getDienThoai());
                taiKhoan1.setRoles(taiKhoan1.getRoles());
                taiKhoan1.setTrangThai(taiKhoan1.isTrangThai());

                return taiKhoanRepository.save(taiKhoan1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteTaiKhoan(String id) {
        TaiKhoan taiKhoan=taiKhoanRepository.findById(id).get();
        if(taiKhoan!=null){
            taiKhoanRepository.delete(taiKhoan);
            return true;
        }
        return false;
    }

    @Override
    public List<TaiKhoan> getAllTaiKhoan() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public TaiKhoan getOneTaiKhoan(String id) {
        return taiKhoanRepository.findById(id).get();
    }
}
