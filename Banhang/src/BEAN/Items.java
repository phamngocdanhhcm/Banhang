package BEAN;

import java.io.Serializable;

public class Items implements Serializable{
	private int id;
	private Phone phone;
	private Laptop laptop;
	private Watch watch;
	private Ipad ipad;
	private int soluong;
	private int giaca;
	private int tonggiatien;
	private String giaca1;
	private String tonggiatien1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public Watch getWatch() {
		return watch;
	}
	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public Ipad getIpad() {
		return ipad;
	}
	public void setIpad(Ipad ipad) {
		this.ipad = ipad;
	}
	public int getGiaca() {
		return giaca;
	}
	public void setGiaca(int giaca) {
		this.giaca = giaca;
	}
	public int getTonggiatien() {
		return tonggiatien;
	}
	public void setTonggiatien(int tonggiatien) {
		this.tonggiatien = tonggiatien;
	}
	public String getGiaca1() {
		return giaca1;
	}
	public void setGiaca1(String giaca1) {
		this.giaca1 = giaca1;
	}
	public String getTonggiatien1() {
		return tonggiatien1;
	}
	public void setTonggiatien1(String tonggiatien1) {
		this.tonggiatien1 = tonggiatien1;
	}
}
