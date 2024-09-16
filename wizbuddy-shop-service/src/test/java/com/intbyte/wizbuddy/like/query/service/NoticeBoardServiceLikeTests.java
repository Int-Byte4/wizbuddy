package com.intbyte.wizbuddy.like.query.service;

import com.intbyte.wizbuddy.like.query.dto.NoticeBoardLikedDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class NoticeBoardServiceLikeTests {

    @Autowired
    private NoticeBoardLikedService noticeBoardLikedService;

    @Test
    @Transactional
    @DisplayName("공지사항 게시글 좋아요 조회")
    public void testFindNoticeBoardLike() {
        int noticeCode = 1;

        List<NoticeBoardLikedDTO> noticeBoardLikedList = noticeBoardLikedService.findLikesByNoticeCode(noticeCode);

        int result = (int)(noticeBoardLikedList.stream().count());

        assertThat(result).isEqualTo(1);
    }
}