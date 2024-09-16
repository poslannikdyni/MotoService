package ru.clevertec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.domain.Moto;
import ru.clevertec.service.MotoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MotoController {

    private final MotoService motoService;

    @GetMapping("/api/v1/all_moto")
    public ResponseEntity<List<Moto>> findAllMoto(){
        List<Moto> cakes = motoService.getAll();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cakes);
    }
}
