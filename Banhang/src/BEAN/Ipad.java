package BEAN;

import java.io.InputStream;

public class Ipad {
	private int maipad;
	private String name;
	private String brand;
	private String dungluong;
	private String hedieuhanh;
	private int ram ;
	private String detail;
	private int    soluong;
	private int    giatien;
	private InputStream inputStream;
    private byte[] image;  
    private String hinhanh;
    private String giatien1;
    
	public int getMaipad() {
		return maipad;
	}
	public String getName() {
		return name;
	}
	public String getBrand() {
		return brand;
	}
	public String getDungluong() {
		return dungluong;
	}
	public String getHedieuhanh() {
		return hedieuhanh;
	}
	public int getRam() {
		return ram;
	}
	public String getDetail() {
		return detail;
	}
	public int getSoluong() {
		return soluong;
	}
	public int getGiatien() {
		return giatien;
	}
	public void setMaipad(int maipad) {
		this.maipad = maipad;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setHedieuhanh(String hedieuhanh) {
		this.hedieuhanh = hedieuhanh;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public void setDungluong(String dungluong) {
		this.dungluong = dungluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
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
