package com.threetier.team1.rollingpaper.DTO;

import com.threetier.team1.rollingpaper.domain.Paper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaperDTO {
    private Long id;
    private String nickname;
    private String password;
    private String content;

    public static PaperDTO fromEntity(Paper paper) {
        return PaperDTO.builder()
                .id(paper.getId())
                .nickname(paper.getNickname())
                .content(paper.getContent())
                .build();
    }

    public static class deletePaper {
        private Long id;
        private String password;
    }
}
