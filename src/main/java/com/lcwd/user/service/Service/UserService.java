package com.lcwd.user.service.Service;

import com.lcwd.user.service.Entities.User;

public interface UserService {
   public User createUser(User user);
   
   public User getUserById(Long userId);
   
   public User updateUser(long userId,User updateUser);
   
   public void deleteUser(long userId);

}
