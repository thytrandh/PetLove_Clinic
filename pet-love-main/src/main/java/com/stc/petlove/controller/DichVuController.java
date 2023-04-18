package com.stc.petlove.controller;

import com.stc.petlove.entities.DatCho;
import com.stc.petlove.entities.DichVu;
import com.stc.petlove.entities.embedded.GiaDichVu;
import com.stc.petlove.entities.embedded.ThongTinDatCho;
import com.stc.petlove.service.IDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dichvu")
public class DichVuController {

    @Autowired
    private IDichVuService iDichVuService;

    @GetMapping("/")
    public String test(){
        return "dichvu";
    }

    @PostMapping("/add")
    public DichVu addDichVu(@RequestBody DichVu dichVu){
        return iDichVuService.addDichVu(dichVu);
    }

    @PostMapping("/addGiaDichVu/{id}")
    public DichVu addGiaDichVu(@PathVariable("id") String id, @RequestBody GiaDichVu giaDichVu){
        return iDichVuService.addGiaDichVu(id,giaDichVu);
    }

    @PutMapping("/update")
    public DichVu updateDichVu(@RequestParam("id") String id, @RequestBody DichVu dichVu){
        return iDichVuService.updateDichVu(String.valueOf(id),dichVu);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteDichVu(@PathVariable("id") String id){
        return iDichVuService.deleteDichVu(String.valueOf(id));
    }

    @GetMapping("/list")
    public List<DichVu> getAllDichVu(){
        return iDichVuService.getAllDichVu();
    }

}
