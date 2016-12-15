package ru.mail.park.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.park.controllers.api.common.ResultJson;
import ru.mail.park.model.user.UserProfile;
import ru.mail.park.service.implementation.AccountService;
import ru.mail.park.service.implementation.SessionService;
import ru.mail.park.service.interfaces.AbstractAccountService;
import ru.mail.park.service.interfaces.AbstractSessionService;

import javax.servlet.http.HttpSession;

/**
 * Created by admin on 10.12.16.
 */
@RestController
public class StatisticController {

    private final AbstractAccountService accountService;
    private final AbstractSessionService sessionService;

    @Autowired
    public StatisticController(AbstractAccountService accountService,
                               AbstractSessionService sessionService) {
        this.accountService = accountService;
        this.sessionService = sessionService;
    }

    @RequestMapping(path = "/user/rating", method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity getWinRate(@RequestParam(name = "email") String email) {

        final String json;

        if(email == null) {
            json = (new ResultJson<>(
                    HttpStatus.FORBIDDEN.value(), null).getStringResult());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(json);
        }

        UserProfile userProfile = accountService.getUser(email);

        if(userProfile == null) {
            json = (new ResultJson<>(
                    HttpStatus.FORBIDDEN.value(), null).getStringResult());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(json);
        }

        Float winRate = (float)userProfile.getWinGames() / (float)userProfile.getCountGames();

        json = (new ResultJson<>(
                HttpStatus.OK.value(), winRate.floatValue()).getStringResult());

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

}
