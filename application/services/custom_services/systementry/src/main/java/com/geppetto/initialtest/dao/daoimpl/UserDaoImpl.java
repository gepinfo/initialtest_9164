package com.geppetto.initialtest.dao.daoimpl;

import com.geppetto.initialtest.model.User;
import com.geppetto.initialtest.repository.UserRepository;
import com.geppetto.initialtest.dao.UserDao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao{

    private final UserRepository userRepository;

     public UserDaoImpl(UserRepository userRepository) {
       this.userRepository = userRepository;
}





}
