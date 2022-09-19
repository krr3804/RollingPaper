package com.threetier.team1.rollingpaper.DTO;

import com.threetier.team1.rollingpaper.domain.Paper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class PaperDTO {
    @Getter
    public static class CreatePaperInfo {
        private String nickname;
        private String password;
        private String content;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ShowListInfo {
        private Long id;
        private String nickname;
        private String content;

        public static ShowListInfo fromEntity(Paper paper) {
            return ShowListInfo.builder()
                    .id(paper.getId())
                    .nickname(paper.getNickname())
                    .content(paper.getContent())
                    .build();
        }
    }
    @Getter
    public static class DeletePaperInfo {
        private Long id;
        private String password;
    }
}
