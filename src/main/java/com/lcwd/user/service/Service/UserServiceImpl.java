package com.lcwd.user.service.Service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.Entities.Order;
import com.lcwd.user.service.Entities.Product;
import com.lcwd.user.service.Entities.User;
import com.lcwd.user.service.Exception.UserCreationException;
import com.lcwd.user.service.Exception.UserNotFoundException;
import com.lcwd.user.service.External.Services.ProductService;
import com.lcwd.user.service.Repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private ProductService productService;
	
	@Override
	public User createUser(User user) {
	    try {
	    	return userRepo.save(user);
	    }catch(Exception e){
	    	 logger.error("Error occurred while creating user: {}", e.getMessage());
	    	   throw new UserCreationException("Failed to create user.", e);
		  }	
	   }
	
	@Override
	public User getUserById(Long userId) {
		 User optionalUser = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
		 
	    Order[] ordersOfUser=restTemplate.getForObject("http://USER-ORDER/orders/user/"+optionalUser.getUserId(),Order[].class );
	    List<Order> orders=Arrays.stream(ordersOfUser).toList();
	    logger.info("{}",orders);
	    
	    List<Order> orderList=orders.stream().map(order->{
	    	ResponseEntity<Product> response=productService.getProductById(order.getProductId());
	    	Product product=response.getBody();
	    	order.setProduct(product);
	    	return order;
	    }).collect(Collectors.toList());
	    
	    optionalUser.setOrders(orderList);
	    return optionalUser;
	}

	@Override
	public User updateUser(long userId, User updateUser) {
		  User optionalUser = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
		if(optionalUser!=null) {
			
			optionalUser.setEmail(updateUser.getEmail());
			optionalUser.setName(updateUser.getName());
			optionalUser.setPassword(updateUser.getPassword());
			return userRepo.save(optionalUser);
		}else {
		  return null;
		}
	}

	@Override
	public void deleteUser(long id) {
		if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
	}
}




//ResponseEntity<Product> forEntity=restTemplate.getForEntity("http://USER-PRODUCT/products/"+order.getProductId(),Product.class);
//Product product=forEntity.getBody();