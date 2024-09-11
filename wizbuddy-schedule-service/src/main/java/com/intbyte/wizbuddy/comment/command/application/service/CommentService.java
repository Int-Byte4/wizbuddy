package com.intbyte.wizbuddy.comment.command.application.service;

import com.intbyte.wizbuddy.comment.command.application.dto.CommentDTO;
import com.intbyte.wizbuddy.comment.command.domain.aggregate.vo.EditCommentInfo;
import com.intbyte.wizbuddy.comment.command.domain.aggregate.vo.response.ResponseAdoptCommentVO;
import com.intbyte.wizbuddy.comment.command.domain.aggregate.vo.response.ResponseDeleteCommentVO;
import com.intbyte.wizbuddy.comment.command.domain.aggregate.vo.response.ResponseInsertCommentVO;
import com.intbyte.wizbuddy.comment.command.domain.aggregate.vo.response.ResponseModifyCommentVO;

public interface CommentService {

    ResponseInsertCommentVO registerComment(CommentDTO comments);

    ResponseModifyCommentVO modifyComment(int commentCode, EditCommentInfo modifyCommentInfo);

    ResponseDeleteCommentVO removeComment(CommentDTO deleteComment);

    ResponseAdoptCommentVO adoptComment(CommentDTO adoptComment);
}