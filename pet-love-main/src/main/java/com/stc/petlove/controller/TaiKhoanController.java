package com.stc.petlove.controller;

import com.stc.petlove.entities.LoaiThuCung;
import com.stc.petlove.entities.TaiKhoan;
import com.stc.petlove.service.ITaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taikhoan")
public class TaiKhoanController {
    @Autowired
    private ITaiKhoanService iTaiKhoanService;

    @GetMapping("/")
    public String test(){
        return "timoday";
    }

    @PostMapping("/add")
    public TaiKhoan addTaiKhoan(@RequestBody TaiKhoan taiKhoan){
        return iTaiKhoanService.addTaiKhoan(taiKhoan);
    }

    @PutMapping("/update")
    public TaiKhoan updateTaiKhoan(@RequestParam("id") String id, @RequestBody TaiKhoan taiKhoan){
        return iTaiKhoanService.updateTaiKhoan(String.valueOf(id),taiKhoan);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteTaiKhoan(@PathVariable("id") String id){
        return iTaiKhoanService.deleteTaiKhoan(String.valueOf(id));
    }

    @GetMapping("/list")
    public List<TaiKhoan> getAllTaiKhoan(){
        return iTaiKhoanService.getAllTaiKhoan();
    }

}
