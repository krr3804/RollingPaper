package com.threetier.team1.rollingpaper.controller;

import com.threetier.team1.rollingpaper.DTO.ApiResponseDTO;
import com.threetier.team1.rollingpaper.DTO.PaperDTO;
import com.threetier.team1.rollingpaper.DTO.PaperDTO.CreatePaperInfo;
import com.threetier.team1.rollingpaper.DTO.PaperDTO.DeletePaperInfo;
import com.threetier.team1.rollingpaper.DTO.PaperDTO.ShowListInfo;
import com.threetier.team1.rollingpaper.service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaperController {

    private final PaperService paperService;

    @GetMapping("/")
    public ResponseEntity<List<ShowListInfo>> getAllPapers() {
        List<ShowListInfo> papers = paperService.getList();
        return ResponseEntity.status(HttpStatus.OK).body(papers);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createPaper(@RequestBody CreatePaperInfo createPaperInfo) {
        paperService.write(createPaperInfo);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO("success"));
    }

    @DeleteMapping("/")
    public ResponseEntity<Object> deletePaper(@RequestBody DeletePaperInfo deletePaperInfo) {
        boolean result = paperService.delete(deletePaperInfo);
        if(result) {
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO("success"));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponseDTO("unauthorized"));
    }
}
