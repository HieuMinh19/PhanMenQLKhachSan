package Utility;

public class Result {
	private boolean flag;
	private String appMessage;
	private StackTraceElement[] sysMessage;
	
	public Result(){
		this.flag = true;
		this.appMessage = null;
		this.sysMessage = null;
	}
	
	public Result(boolean flag){
		this.flag = flag;
		this.appMessage = null;
		this.sysMessage = null;
	}
	public Result(String appMessage, boolean flag, StackTraceElement[] stackTraceElements){
		this.appMessage = appMessage;
		this.flag = flag;
		this.sysMessage = stackTraceElements;	
	}	
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getAppMessage() {
		return appMessage;
	}
	public void setAppMessage(String appMessage) {
		this.appMessage = appMessage;
	}
	public StackTraceElement[] getSysMessage() {
		return sysMessage;
	}
	public void setSysMessage(StackTraceElement[] sysMessage) {
		this.sysMessage = sysMessage;
	}
	
	
	public void StackTrace() {
		System.out.println(flag);
		System.out.println(appMessage);
		System.out.println(sysMessage);
	}
	
	
}
