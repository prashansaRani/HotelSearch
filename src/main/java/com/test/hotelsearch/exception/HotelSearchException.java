package com.test.hotelsearch.exception;

public class HotelSearchException extends Exception{

private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public HotelSearchException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public HotelSearchException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}



	public HotelSearchException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}



	public HotelSearchException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}



	public HotelSearchException(String msg) {
		super();
		this.msg = msg;
	}
	
}
