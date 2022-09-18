package com.threetier.team1.rollingpaper.domain;

import com.threetier.team1.rollingpaper.DTO.PaperDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String password;
    private String content;

    public Paper(PaperDTO paperDTO) {
        this.nickname = paperDTO.getNickname();
        this.password = paperDTO.getPassword();
        this.content = paperDTO.getContent();
    }


}
