package com.stc.petlove.service.implement;

import com.stc.petlove.entities.DatCho;
import com.stc.petlove.entities.embedded.ThongTinDatCho;
import com.stc.petlove.repository.DatChoRepository;
import com.stc.petlove.service.IDatChoService;
import com.stc.petlove.utils.EnumTrangThaiDatCho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import com.stc.petlove.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class DatChoServiceImpl implements IDatChoService {

    @Autowired
    private DatChoRepository datChoRepository;

    @Override
    public DatCho addThongTinDatCho(String id, ThongTinDatCho thongTinDatCho) {
        Optional<DatCho> datCho=datChoRepository.findById(id);
        if(!datCho.isPresent()){
            throw new NotFoundException(String.format("Id  %s không tồn tại",id));
        }
        datCho.get().getThongTinDatChos().add(thongTinDatCho);
        return datChoRepository.save(datCho.get());
    }

    @Override
    public DatCho addDatCho(DatCho datCho) {
       DatCho datCho1=new DatCho();
        if(datCho!=null){
            datCho1.setEmail(datCho.getEmail());
            datCho1.setCanDan(datCho.getCanDan());
            datCho1.setThongTinDatChos(datCho.getThongTinDatChos());
            datCho1.setThoiGian(datCho.getThoiGian());
            datCho1.setTrangThaiDatCho(EnumTrangThaiDatCho.DAT_CHO.name());
            datCho1.setTrangThai(true);
            return datChoRepository.save(datCho1);
        }
        return null;
    }

    @Override
    public DatCho updateDatCho(String id, DatCho datCho) {
        if(datCho!=null){
            DatCho datCho1=datChoRepository.findById(id).get();
            if(datCho1!=null){
                datCho1.setEmail(datCho.getEmail());
                datCho1.setCanDan(datCho.getCanDan());
                datCho1.setThongTinDatChos(datCho.getThongTinDatChos());
                datCho1.setThoiGian(datCho.getThoiGian());
                datCho1.setTrangThaiDatCho(EnumTrangThaiDatCho.DAT_CHO.name());
                datCho1.setTrangThai(true);
                return datChoRepository.save(datCho1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteDatCho(String id) {
        DatCho datCho=datChoRepository.findById(id).get();
        if(datCho!=null){
            datChoRepository.delete(datCho);
            return true;
        }
        return false;
    }

    @Override
    public List<DatCho> getAllDatCho() {
        return datChoRepository.findAll();
    }
}
