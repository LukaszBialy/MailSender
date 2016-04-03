package com.white.tech.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    public static final String QUERY = "SELECT email FROM T" +
            "  WHERE MOD(CRC32(CONCAT(date, email)), :numberOfInstances) = :instanceId LIMIT 100;";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<String> getMails(int instanceId, int numberOfInstances) {

        Map<String, Integer> params = new HashMap<>();
        params.put("numberOfInstances", numberOfInstances);
        params.put("instanceId", instanceId);

        return jdbcTemplate.queryForList(QUERY, params, String.class);
    }
}
