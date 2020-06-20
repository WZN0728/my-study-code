package com.jdk;

public class Owner implements Person{

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

	@Override
	public String findHouse(){
		System.out.println("开始找房子了");
		return "找到了";
	}
	
}