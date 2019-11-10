package java_1028;

public abstract class HomeAppliance implements Remote.remotebutton{
	public void onClick() {
		menu();
	}
	private String HAName;
	private boolean HaPower;
	public abstract void showStatus();
	public abstract void menu();
	
}
