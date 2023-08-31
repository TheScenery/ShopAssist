package io.thescenery.shopAssist.user.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;

    private String password;
}
