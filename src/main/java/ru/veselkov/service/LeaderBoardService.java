package ru.veselkov.service;

import ru.veselkov.converter.Converter;
import ru.veselkov.dao.leaderBoard.LeaderBoardDao;
import ru.veselkov.dao.user.UserModel;
import ru.veselkov.service.user.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LeaderBoardService {
    private final Converter<UserModel, UserDTO> userModelToUserDtoConverter;
    private final LeaderBoardDao leaderBoardDao;

    public LeaderBoardService(LeaderBoardDao leaderBoardDao, Converter<UserModel, UserDTO> userModelToUserDtoConverter) {
        this.leaderBoardDao = leaderBoardDao;
        this.userModelToUserDtoConverter = userModelToUserDtoConverter;
    }

    public List<UserDTO> printLeaderBoard() {
        return leaderBoardDao.getLeaderBoard().stream()
                .map(userModelToUserDtoConverter::convert)
                .collect(Collectors.toList());
    }
}
