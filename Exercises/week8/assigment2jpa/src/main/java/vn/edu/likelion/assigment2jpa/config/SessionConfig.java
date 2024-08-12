package vn.edu.likelion.assigment2jpa.config;

import org.springframework.stereotype.Component;
import vn.edu.likelion.assigment2jpa.entity.UserEntity;

@Component
public class SessionConfig {

    private UserEntity userEntity = null;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
