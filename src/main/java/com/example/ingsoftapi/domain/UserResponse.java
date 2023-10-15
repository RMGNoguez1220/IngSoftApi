package com.example.ingsoftapi.domain;

import java.util.HashMap;
import java.util.List;

import com.example.ingsoftapi.model.User;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserResponse extends  Response{
    private User user;
    private List<User> listUser;
    HashMap<String,Object> data = new HashMap<>();
    public UserResponse(User user,String message,int status,boolean flag){
        super(flag, message, status);
        this.user=user;

    }

    public UserResponse(String message,int status,boolean flag){
        super(flag, message, status);

    }

    //GET All
    public UserResponse(List<User> listUser,String message, int status, boolean flag){
        super(flag, message, status);
        this.listUser=listUser;

    }
    public Object response() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.user);
        return data;
    }

    public Object response2() {
        data.put("Flag", isFlag());
        data.put("Message", getMensaje());
        data.put("Status", getStatus());
        data.put("Data", this.listUser);
        return data;
    }
}

