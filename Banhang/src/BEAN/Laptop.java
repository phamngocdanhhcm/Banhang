package BEAN;

import java.io.InputStream;

public class Laptop {
	private int malaptop ;
	private String name;
	private String brand;
	private int ram ; 
	private String chipdohoa;
	private String phangiai;
	private String kichthuoc;
	private String series;
	private int    soluong;
	private String detail;
	private int    giatien;
	private InputStream inputStream;
    private byte[] image;  
    private String hinhanh;
    private String giatien1;
	
	public int getMalaptop() {
		return malaptop;
	}
	public String getName() {
		return name;
	}
	public String getBrand() {
		return brand;
	}
	public int getRam() {
		return ram;
	}
	public String getChipdohoa() {
		return chipdohoa;
	}
	public String getPhangiai() {
		return phangiai;
	}
	public String getKichthuoc() {
		return kichthuoc;
	}
	public String getSeries() {
		return series;
	}
	public int getSoluong() {
		return soluong;
	}
	public String getDetail() {
		return detail;
	}
	public int getGiatien() {
		return giatien;
	}
	public void setMalaptop(int malaptop) {
		this.malaptop = malaptop;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public void setChipdohoa(String chipdohoa) {
		this.chipdohoa = chipdohoa;
	}
	public void setPhangiai(String phangiai) {
		this.phangiai = phangiai;
	}
	public void setKichthuoc(String kichthuoc) {
		this.kichthuoc = kichthuoc;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public void setDetail(String detail) {
		this.detail = detail;
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
