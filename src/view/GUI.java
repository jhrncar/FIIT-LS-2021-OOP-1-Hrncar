package view;

import control.*;
import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;

public class GUI extends Application{
    private Button vytvor_order = new Button("Vytvor order");
    private Button spracuj_order = new Button("Spracuj order");
    private Button vypis_order = new Button("Vypis order");
    private Button posun_order = new Button("Posun order");

    private TextField zelezo = new TextField("0");
    private TextField ocel = new TextField("0");
    private TextField roxor = new TextField("0");
    private TextField ocelova_tyc = new TextField("0");
    private TextField srob = new TextField("0");
    private TextField posun = new TextField("Cislo objednavky");

    public TextArea konzola = new TextArea();
    private ScrollPane skrol = new ScrollPane();
    private Label nazov = new Label("Hrncar steel");

    control control = new control();

    @Override
    public void start(Stage main) throws Exception {
        main.setTitle("Hrncar steel");
        BorderPane pane = new BorderPane();
        GridPane grid = new GridPane();
        HBox hbox = new HBox();

        grid.setHgap(10);
        grid.setVgap(10);
        
        skrol.setContent(pane);

        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(nazov);
        pane.setTop(hbox);
        nazov.setFont(new Font("Arial", 32));


        Text zelezo_text = new Text("Zelezo:");
        zelezo_text.setFont(Font.font("Arial", 15));
        grid.add(zelezo_text, 1, 1);
        grid.add(zelezo,2,1);

        Text ocel_text = new Text("Ocel:");
        ocel_text.setFont(Font.font("Arial", 15));
        grid.add(ocel_text, 1, 2);
        grid.add(ocel,2,2);

        Text roxor_text = new Text("Roxor:");
        roxor_text.setFont(Font.font("Arial", 15));
        grid.add(roxor_text, 1, 3);
        grid.add(roxor,2,3);

        Text ocelova_tyc_text = new Text("Ocelova tyc:");
        ocelova_tyc_text.setFont(Font.font("Arial", 15));
        grid.add(ocelova_tyc_text, 1, 4);
        grid.add(ocelova_tyc,2,4);

        Text srob_text = new Text("Srob:");
        srob_text.setFont(Font.font("Arial", 15));
        grid.add(srob_text, 1, 5);
        grid.add(srob,2,5);

        grid.add(posun,5,5);

    
        grid.add(vytvor_order, 5, 1);
        grid.add(spracuj_order, 5, 2);
        grid.add(vypis_order,5,3);
        grid.add(posun_order,5,4);

        pane.setCenter(grid);
        
        pane.setBottom(konzola);
        konzola.setEditable(false);


        vytvor_order.setOnAction(e -> {
            try {
                konzola.appendText(control.vytvor(Integer.parseInt(zelezo.getText()), Integer.parseInt(ocel.getText()), Integer.parseInt(roxor.getText()), Integer.parseInt(ocelova_tyc.getText()), Integer.parseInt(srob.getText())));
            } 
            catch (Invalid_input e1) {
                konzola.appendText("Vstup musi byt vacsi ako 0\n");
            }
        });
        spracuj_order.setOnAction(e -> {
            try {
                konzola.appendText(control.spracuj());
            } catch (Invalid_input e1) {
                konzola.appendText("Nebola zadana ziadna objednavka\n");
            }
        });

        vypis_order.setOnAction(e -> konzola.appendText(control.vypis()));

        
        posun_order.setOnAction(e -> {try {
            konzola.appendText(control.posun(Integer.parseInt(posun.getText())));
        } 
        catch (NumberFormatException e1) {
            konzola.appendText("Nespravny format cisla objednavky\n");
        }
        });
        
        
        

        main.setScene(new Scene(skrol, 500, 400));
        main.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
