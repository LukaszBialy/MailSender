package com.white.tech.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Value("${instance.id}")
    int instanceId;

    @Value("${number.of.instances}")
    int numberOfInstances;

    @Autowired
    private UserDao userDao;

    public List<String> getMails() {
        return userDao.getMails(instanceId, numberOfInstances);
    }
}
