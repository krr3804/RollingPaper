package com.threetier.team1.rollingpaper.service;

import com.threetier.team1.rollingpaper.DTO.PaperDTO;
import com.threetier.team1.rollingpaper.domain.Paper;

import java.util.List;

public interface PaperService {
    List<PaperDTO> getList();

    void write(PaperDTO paperDTO);

    void delete(Long id);
}
