package ru.mail.park.util;

import org.junit.Test;
import ru.mail.park.controllers.api.exeptions.AirDroneExeptions;

import static org.junit.Assert.*;

/**
 * Created by admin on 22.10.16.
 */
public class RequestValidatorTest {

    @Test
    public void testEmailValidate() {
        assertEquals(true, RequestValidator.emailValidate("mail@mail.ru"));
    }

    @Test
    public void testBadEmail() {
        int fails = 0;

        try {
            RequestValidator.emailValidate("mail@mailru");
        } catch (AirDroneExeptions.UserBadEmailException e) {
            fails++;
        }

        try {
            RequestValidator.emailValidate("mailmail.ru");
        } catch (AirDroneExeptions.UserBadEmailException e) {
            fails++;
        }

        try {
            RequestValidator.emailValidate("mail");
        } catch (AirDroneExeptions.UserBadEmailException e) {
            fails++;
        }

        try {
            RequestValidator.emailValidate("");
        } catch (AirDroneExeptions.UserBadEmailException e) {
            fails++;
        }

        try {
            RequestValidator.emailValidate(null);
        } catch (AirDroneExeptions.UserBadEmailException e) {
            fails++;
        }

        final int standard = 5;
        assertEquals(standard, fails);

    }


    @Test
    public void testPasswordValidate() throws AirDroneExeptions.UserBadPasswordException {
        assertEquals(true, RequestValidator.passwordValidate("123456aA"));
    }

    @Test
    public void testBadPasswordValidate() throws Exception {
        int fails = 0;

        try {
            RequestValidator.passwordValidate(null);
        } catch (AirDroneExeptions.UserBadPasswordException e) {
            fails++;
        }

        try {
            RequestValidator.passwordValidate("");
        } catch (AirDroneExeptions.UserBadPasswordException e) {
            fails++;
        }

        try {
            RequestValidator.passwordValidate("12345678");
        } catch (AirDroneExeptions.UserBadPasswordException e) {
            fails++;
        }

        try {
            RequestValidator.passwordValidate("qf39qD");
        } catch (AirDroneExeptions.UserBadPasswordException e) {
            fails++;
        }

        try {
            RequestValidator.passwordValidate("jngjweJNFWKMNAKqqnMKFQW");
        } catch (AirDroneExeptions.UserBadPasswordException e) {
            fails++;
        }

        final int standard = 5;
        assertEquals(fails, standard);
    }

}