package view.adminPane;

import controller.AdminViewController;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AdminView {

	private Stage stage = new Stage();

	public AdminView(AdminViewController adminViewController){
		stage.setTitle("ADMIN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(880);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 410);
		BorderPane borderPane = new AdminMainPane(adminViewController.getOrderFacade());
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		borderPane.setBackground(new Background(new BackgroundFill(Color.SNOW,new CornerRadii(0),new Insets(0))));
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
		adminViewController.setView(this); // controller.Observer
	}

    public void update() {
		// na sander
    }
}
