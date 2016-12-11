package ru.mail.park.service.interfaces;

import ru.mail.park.model.user.UserProfile;

/**
 * Created by admin on 10.12.16.
 */
public interface AbstractStatisticService {
    public Float getWinRate(UserProfile userProfile);
}
