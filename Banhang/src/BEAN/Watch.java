package BEAN;

import java.io.InputStream;

public class Watch {
	private int madongho;
	private String name;
	private String brand;
	private String manhinh;
	private String congnghemh;
	private String hedieuhanh;
	private String detail;
	private int    soluong;
	private int    giatien;
	private InputStream inputStream;
    private byte[] image;  
    private String hinhanh;
    private String giatien1;
	
	public int getMadongho() {
		return madongho;
	}
	public String getName() {
		return name;
	}
	public String getBrand() {
		return brand;
	}
	public String getManhinh() {
		return manhinh;
	}
	public String getCongnghemh() {
		return congnghemh;
	}
	public String getHedieuhanh() {
		return hedieuhanh;
	}
	public String getDetail() {
		return detail;
	}
	public int getGiatien() {
		return giatien;
	}
	public int getSoluong() {
		return soluong;
	}
	
	public void setMadongho(int madongho) {
		this.madongho = madongho;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setManhinh(String manhinh) {
		this.manhinh = manhinh;
	}
	public void setCongnghemh(String congnghemh) {
		this.congnghemh = congnghemh;
	}
	public void setHedieuhanh(String hedieuhanh) {
		this.hedieuhanh = hedieuhanh;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setGiatien(int giatien) {
		this.giatien = giatien;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
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
