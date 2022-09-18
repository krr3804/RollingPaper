package com.threetier.team1.rollingpaper.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.threetier.team1.rollingpaper.DTO.PaperDTO;
import com.threetier.team1.rollingpaper.domain.Paper;
import com.threetier.team1.rollingpaper.repository.PaperRepository;
import com.threetier.team1.rollingpaper.service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaperController {

    private final PaperService paperService;
    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping("")
    public ResponseEntity<List<PaperDTO>> getList() {
        List<PaperDTO> list = paperService.getList();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("")
    public ResponseEntity<Object> write(@RequestBody PaperDTO paperDTO) {
        paperService.write(paperDTO);
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

    @PostMapping("delete")
    public ResponseEntity<Object> delete(@RequestBody PaperDTO paperDTO) {
        boolean result = paperService.delete(paperDTO.getId(), paperDTO.getPassword());
        if(result == true) {
            return ResponseEntity.status(HttpStatus.OK).body("success");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("unauthorized");
    }
}
