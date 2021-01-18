package lec09.ex02.p;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		FlowPane pane = new FlowPane();
		pane.setHgap(10);
		pane.setPadding(new Insets(10));
		
		Button btn1 = new Button("종료1");
		Button btn2 = new Button("종료2");
		Button btn3 = new Button("종료3");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
		});
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				Platform.exit();
				
			}
		});
		
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
		
		pane.getChildren().addAll(btn1, btn2, btn3);
		Scene scene = new Scene(pane, 400, 200);
		stage.setScene(scene);
		stage.show();
		
	}
	
	@Override
	public void stop() throws Exception {
		
		System.out.println("stop() \t JavaFx 종료시 호출되는 구간");
		
	}

}
