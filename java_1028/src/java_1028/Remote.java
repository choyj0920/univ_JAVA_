package java_1028;

public class Remote {
	interface remotebutton{
		void onClick();
	}
	remotebutton button;
	void setHA(remotebutton click) {
		this.button=click;
	}
	void onTouch() {
		this.button.onClick();
	}
}
