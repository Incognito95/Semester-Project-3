package dtos;

import entities.User;

public class UserDTO {
    private String user_name;

    public UserDTO(User P) {
        this.user_name = P.getUserName();
    }

    public UserDTO(String un) {
        this.user_name = un;
    }

    public UserDTO() {}

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


}
