package com.whs.dao;

import com.whs.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    List<User> findAll() throws IOException;
    User findById(int id);
}
