package com.stc.petlove.controller;

import com.stc.petlove.entities.DatCho;
import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.entities.embedded.ThongTinDatCho;
import com.stc.petlove.service.IDatChoService;
import com.stc.petlove.service.ITaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datcho")
public class DatChoController {
    @Autowired
    private IDatChoService iDatChoService;


    @GetMapping("/")
    public String test(){
        return "datcho";
    }

    @PostMapping("/add")
    public DatCho addDatCho(@RequestBody DatCho datCho){
        return iDatChoService.addDatCho(datCho);
    }

    @PostMapping("/addThongTinDC/{id}")
    public DatCho addThongTinDc(@PathVariable("id") String id, @RequestBody ThongTinDatCho thongTinDatCho){
        return iDatChoService.addThongTinDatCho(id,thongTinDatCho);
    }

    @PutMapping("/update")
    public DatCho updateDatCho(@RequestParam("id") String id, @RequestBody DatCho datCho){
        return iDatChoService.updateDatCho(String.valueOf(id),datCho);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteDatCho(@PathVariable("id") String id){
        return iDatChoService.deleteDatCho(String.valueOf(id));
    }

    @GetMapping("/list")
    public List<DatCho> getAllDatCho(){
        return iDatChoService.getAllDatCho();
    }


}
