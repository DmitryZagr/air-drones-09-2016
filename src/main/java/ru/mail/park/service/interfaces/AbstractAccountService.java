package ru.mail.park.service.interfaces;

import org.springframework.stereotype.Component;
import ru.mail.park.model.user.UserProfile;

/**
 * Created by admin on 30.09.16.
 */
@Component
public interface AbstractAccountService {
    boolean addUser(String username, String email, String password);

    UserProfile getUser(String email);

    boolean removeUser(String email, String password);

    boolean updateUser(String username, String email, String password, String newPassword);

}
