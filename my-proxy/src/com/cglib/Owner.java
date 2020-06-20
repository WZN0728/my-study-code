package com.cglib;

public class Owner{

	private String pingMi;
	
	private String juShi;
	
	private String chaoXiang;
	
	public String getPingMi() {
		return pingMi;
	}

	public void setPingMi(String pingMi) {
		this.pingMi = pingMi;
	}

	public String getJuShi() {
		return juShi;
	}

	public void setJuShi(String juShi) {
		this.juShi = juShi;
	}

	public String getChaoXiang() {
		return chaoXiang;
	}

	public void setChaoXiang(String chaoXiang) {
		this.chaoXiang = chaoXiang;
	}

	public void findHouse(){
		System.out.println("开始找房子了");
	}
	
}