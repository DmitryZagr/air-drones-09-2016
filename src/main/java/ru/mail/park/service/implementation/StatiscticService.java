package ru.mail.park.service.implementation;

import ru.mail.park.model.user.UserProfile;
import ru.mail.park.service.interfaces.AbstractStatisticService;

/**
 * Created by admin on 10.12.16.
 */
public class StatiscticService implements AbstractStatisticService {

    @Override
    public Float getWinRate(UserProfile userProfile) {

        if(userProfile == null || userProfile.getEmail() == null)
            return null;

        return (float)userProfile.getCountGames() / userProfile.getWinGames();
    }
}
