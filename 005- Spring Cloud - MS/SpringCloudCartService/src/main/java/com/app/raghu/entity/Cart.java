package com.app.raghu.entity;

public class Cart {

	private Integer cartId;
	private String cartCode;
	private Double cartCost;
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public String getCartCode() {
		return cartCode;
	}
	public void setCartCode(String cartCode) {
		this.cartCode = cartCode;
	}
	public Double getCartCost() {
		return cartCost;
	}
	public void setCartCost(Double cartCost) {
		this.cartCost = cartCost;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartCode=" + cartCode + ", cartCost=" + cartCost + "]";
	}
	
	
}
