package ru.mail.park.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.park.controllers.api.common.ResultJson;
import ru.mail.park.model.user.UserProfile;
import ru.mail.park.service.implementation.AccountService;
import ru.mail.park.service.implementation.SessionService;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 10.12.16.
 */
@RestController
public class StatisticController {

    private final AccountService accountService;
    private final SessionService sessionService;

    @Autowired
    public StatisticController(AccountService accountService,
                               SessionService sessionService) {
        this.accountService = accountService;
        this.sessionService = sessionService;
    }

    @RequestMapping(path = "/user/rating", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity getWinRate(HttpSession httpSession) {

        final String email = sessionService.getAuthorizedEmail(httpSession.getId());

        if(email == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResultJson<>(
                    HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED).getStringResult());

        UserProfile userProfile = accountService.getUser(email);

        Float winRate = (float)userProfile.getWinGames() / userProfile.getCountGames();

        final String json = (new ResultJson<>(
                HttpStatus.OK.value(), winRate.floatValue()).getStringResult());

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

}
