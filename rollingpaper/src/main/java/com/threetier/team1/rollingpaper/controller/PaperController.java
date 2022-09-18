package com.threetier.team1.rollingpaper.controller;

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

    private static PaperService paperService;

    @Autowired
    private PaperRepository paperRepository;

    @GetMapping("/papers")
    public ResponseEntity<List<Paper>> getAllPapers() {
        List<Paper> papers = paperRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(papers);
    }

    @GetMapping("/main")
    public String main() {
        return "hello.";
    }

    @PostMapping("/")
    public ResponseEntity<Object> write(@RequestBody PaperDTO paperDTO) {
        paperService.write(paperDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("delete")
    public ResponseEntity<Object> delete(@RequestBody PaperDTO paperDTO) {
        boolean result = paperService.delete(paperDTO.getId(), paperDTO.getPassword());
        if(result == true) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
