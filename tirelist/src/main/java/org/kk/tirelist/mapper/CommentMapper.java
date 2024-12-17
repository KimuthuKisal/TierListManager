package org.kk.tirelist.mapper;

import java.time.LocalDateTime;

import org.kk.tirelist.dto.Comment.CommentDto;
import org.kk.tirelist.dto.Comment.CreateCommentDto;
import org.kk.tirelist.model.CommentModel;

public class CommentMapper {
    public static CommentDto mapCommentToCommentDto(CommentModel commentModel) {
        return new CommentDto(
            commentModel.getId(),
            commentModel.getTireId(),
            commentModel.getUserId(),
            commentModel.getComment(),
            commentModel.getCreatedOn()
        );
    }

    public static CommentModel mapCreateCommentDtoToComment(CreateCommentDto createCommentDto) {
        return new CommentModel(
            createCommentDto.getTireId(),
            createCommentDto.getUserId(),
            createCommentDto.getComment(),
            LocalDateTime.now()
        );
    }
}
