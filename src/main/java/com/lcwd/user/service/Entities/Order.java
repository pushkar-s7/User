package com.lcwd.user.service.Entities;

import java.time.LocalDateTime;


import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Order {
	private Long id;
    private Long userId;
    private Long productId;
    private int quantity;
    private String status;
    private Product product;
    
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime lastModifiedDate;
	@PrePersist
	protected void onCreate() {
		  lastModifiedDate=LocalDateTime.now();
	}
	
	public Order() {
		super();
	}
	public Order(Long id, Long userId, Long productId, int quantity, String status, Product product,
			LocalDateTime lastModifiedDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.status = status;
		this.product = product;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	   
		
	  
}





























//@Temporal(TemporalType.TIMESTAMP)
//@Column(name="last_modified_date")
//private LocalDateTime lastModifiedDate;
//@PrePersist
//protected void onCreate() {
//	  lastModifiedDate=LocalDateTime.now();
//}