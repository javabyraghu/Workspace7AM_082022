package com.app.raghu;

public class Process {

	private Integer pid;
	private String pcode;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	@Override
	public String toString() {
		return "Process [pid=" + pid + ", pcode=" + pcode + "]";
	}
	
	
}
