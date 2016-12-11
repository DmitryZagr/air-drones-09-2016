package ru.mail.park.model.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jetbrains.annotations.Nullable;

public class UserProfile {

    private String  username;
    private String  email;
    @JsonIgnore
    private String  password;
    private int countGames = 0;
    private int winGames = 0;

    public UserProfile(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getWinGames() {
        return winGames;
    }

    public void setWinGames(int winGames) {
        this.winGames = winGames;
    }

    public int getCountGames() {
        return countGames;
    }

    public void setCountGames(int countGames) {
        this.countGames = countGames;
    }

    public UserProfile() {}

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) { this.password = password; }

    public String getEmail() { return  email; }

    public void setEmail(String email) {
        this.email = email;
    }
}
