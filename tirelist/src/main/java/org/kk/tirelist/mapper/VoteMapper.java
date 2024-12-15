package org.kk.tirelist.mapper;

import java.time.LocalDateTime;

import org.kk.tirelist.dto.vote.CreateVoteDto;
import org.kk.tirelist.dto.vote.VoteDto;
import org.kk.tirelist.model.VoteModel;

public class VoteMapper {
    public static VoteDto mapVoteToVoteDto(VoteModel vote) {
        return new VoteDto(
            vote.getId(),
            vote.getItemId(),
            vote.getTireId(),
            vote.getUserId(),
            vote.getValue(),
            vote.getCreatedOn()
        );
    }

    public static VoteModel mapCreateVoteDtoToVote(CreateVoteDto createVoteDto) {
        return new VoteModel(
            createVoteDto.getItemId(),
            createVoteDto.getTireId(),
            createVoteDto.getUserId(),
            createVoteDto.getValue(),
            LocalDateTime.now()
        );
    }
}
