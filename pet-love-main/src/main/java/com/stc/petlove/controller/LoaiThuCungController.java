package com.stc.petlove.controller;

import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.service.ILoaiThuCungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loaithucung")
public class LoaiThuCungController {

    @Autowired
    private ILoaiThuCungService iLoaiThuCungService;

    @GetMapping("/")
    public String test(){
        return "timoday";
    }

    @PostMapping("/add")
    public LoaiThuCung addLoaiThuCung(@RequestBody LoaiThuCung loaiThuCung){
        return iLoaiThuCungService.addLoaiThuCung(loaiThuCung);
    }

    @PutMapping("/update")
    public LoaiThuCung updaLoaiThuCung(@RequestParam("id") String id, @RequestBody LoaiThuCung loaiThuCung){
        return iLoaiThuCungService.updateLoaiThuCung(String.valueOf(id),loaiThuCung);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteLoaiThuCung(@PathVariable("id") String id){
        return iLoaiThuCungService.deteleLoaiThuCung(String.valueOf(id));
    }

    @GetMapping("/list")
    public List<LoaiThuCung> getAllLoaiThuCung(){
        return iLoaiThuCungService.getAllLoaiThuCung();
    }


}
