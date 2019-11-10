package java_1030;

public class Button {
	interface onClickInterface{
		void onClick();
	}
	onClickInterface click;
	void setOnclickInterface(onClickInterface click) {
		this.click=click;
	}
	void onTouch() {
		this.click.onClick();
	}
}
