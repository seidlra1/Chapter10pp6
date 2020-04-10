import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;


public class SlidersModified extends Application {
    private Ellipse ellipse;
    private Slider xSlider, ySlider;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ellipse = new Ellipse(250, 150, 150, 75);
        ellipse.setFill(Color.SALMON);

        xSlider = new Slider(0, 200, 150);
        xSlider.setShowTickMarks(true);
        xSlider.setPadding(new Insets(0, 20, 20, 80));

        // use event listener instead of binding the ellipse to the slider property

        xSlider.setOnDragDetected(this::processXResize);
        //xSlider.setOnDragOver(this::processXResize);

        //ellipse.radiusXProperty().bind(xSlider.valueProperty());


        ySlider = new Slider(0, 100, 75);
        ySlider.setOrientation(Orientation.VERTICAL);
        ySlider.setShowTickMarks(true);
        ySlider.setPadding(new Insets(0, 20, 20, 80));

        // use event listener instead of binding the ellipse to the slider property
        ySlider.setOnDragDetected(this::processYResize);
        ySlider.setOnDragEntered(this::processYResize);
        ySlider.setOnDragDone(this::processYResize);
        ySlider.setOnDragDropped(this::processYResize);
        ySlider.setOnDragExited(this::processYResize);

        //ySlider.setOnDragOver(this::processYResize);

        //ellipse.radiusYProperty().bind(ySlider.valueProperty());


        BorderPane pane = new BorderPane();
        pane.setLeft(ySlider);
        pane.setBottom(xSlider);
        pane.setCenter(ellipse);
        pane.setStyle("-fx-background-color: grey");

        Scene scene = new Scene(pane, 500, 300);

        primaryStage.setTitle("Ellipse Sliders");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // set the ellipses X radius each time the X axis slider moves
    public void processXResize(Event event) {
        ellipse.setRadiusX(xSlider.getValue());
    }

    // set the ellipses X radius each time the X axis slider moves
    public void processYResize(Event event) {

        ellipse.setRadiusY(ySlider.getValue());

    }

}



