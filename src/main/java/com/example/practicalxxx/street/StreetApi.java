package com.example.practicalxxx.street;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/streets")
public class StreetApi {
    @Autowired
    private StreetService streetService;
    @GetMapping
    public ResponseEntity<List<Street>> getList(@RequestParam(defaultValue = "")String name,@RequestParam(defaultValue = "0")int districtId){
        return ResponseEntity.ok(streetService.findAll(name, districtId));
    }
    @PostMapping
    public ResponseEntity<Street> save(@RequestBody Street street){
        return ResponseEntity.ok(streetService.save(street));
    }
}
