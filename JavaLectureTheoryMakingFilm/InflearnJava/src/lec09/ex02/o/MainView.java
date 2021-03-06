package lec09.ex02.o;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {
	
	@Override
	public void init() throws Exception {
		System.out.println("init() \t JavaFx 초기화 로직 구현 구간");
	}

	@Override
	public void start(Stage stage) throws Exception {
		System.out.println("start() \t 화면 구성을 위한 로직 구간");
		stage.show();
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println("stop() \t JavaFx 종료시 호출되는 구간");
	}
	
}
