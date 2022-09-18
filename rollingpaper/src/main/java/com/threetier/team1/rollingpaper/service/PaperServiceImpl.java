package com.threetier.team1.rollingpaper.service;

import com.threetier.team1.rollingpaper.DTO.PaperDTO;
import com.threetier.team1.rollingpaper.domain.Paper;
import com.threetier.team1.rollingpaper.repository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaperServiceImpl implements PaperService{

    private static PaperRepository paperRepository;

    @Override
    public List<PaperDTO> getList() {
        List<Paper> papers = paperRepository.findAll();
        return papers.stream().map(PaperDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void write(PaperDTO paperDTO) {
        Paper paper = new Paper(paperDTO);
        paperRepository.save(paper);
    }

    @Override
    public void delete(Long id) {
        paperRepository.deleteById(id);
    }
}
