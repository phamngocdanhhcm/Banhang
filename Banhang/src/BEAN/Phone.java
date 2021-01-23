package BEAN;

import java.io.InputStream;

public class Phone {
	private int idphone;
	private String name;
	private String brand;
	private int    quantity;
	private String moredetail;
	private String color;
	private int memory;
	private int giatien;
	private InputStream inputStream;
    private byte[] image;  
    private String hinhanh;
    private String giatien1;
    
    
    public byte[] getImage() {
        return this.image;
    }
 
	
	public int getIdphone() {
		return idphone;
	}
	public String getName() {
		return name;
	}
	public String getBrand() {
		return brand;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getMoredetail() {
		return moredetail;
	}
	public String getColor() {
		return color;
	}
	public int getMemory() {
		return memory;
	}
	public int getGiatien() {
		return giatien;
	}
	public void setIdphone(int idphone) {
		this.idphone = idphone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setMoredetail(String moredetail) {
		this.moredetail = moredetail;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public void setGiatien(int giatien) {
		this.giatien = giatien;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public String getHinhanh() {
		return hinhanh;
	}


	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}


	public String getGiatien1() {
		return giatien1;
	}


	public void setGiatien1(String giatien1) {
		this.giatien1 = giatien1;
	}


}
