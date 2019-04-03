/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * @authors CJ
 */

package fxwindowtest;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
//import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.stage.Stage;


public class FxWindowTest extends Application {
    
     File file = new File("C:\\Users\\CJ\\Documents\\NetBeansProjects\\fxWindowTest\\src\\fxwindowtest\\file.txt"); 
     File realFile = new File("C:\\Users\\CJ\\Documents\\NetBeansProjects\\fxWindowTest\\src\\fxwindowtest\\inlist_rsp_Cepheid"); 
    
    @Override
    public void start(Stage primaryStage) {
        
        Text scenetitle = new Text("Input");
        scenetitle.setId("title");
        
        Label modelName = new Label("Model Name: ");
        TextField modelTextField = new TextField();
        
        Label x = new Label("X: ");
        TextField xTextField = new TextField();
        
        Label z = new Label("Z: ");
        TextField zTextField = new TextField();
        
        Label mass = new Label("Mass: ");
        TextField massTextField = new TextField();
        
        Label lum = new Label("Luminosity: ");
        TextField lumTextField = new TextField();
        
        Label temp = new Label("Temperature: ");
        TextField tempTextField = new TextField();
        
        Label period = new Label("# of Period: ");
        TextField periodTextField = new TextField();
        
        Button btn = new Button();
        btn.setId("shiny-orange");
        
        btn.setText("Click Me");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You Clicked The Button!");
                System.out.println("Model  : " + modelTextField.getText());
                System.out.println("X      : " + xTextField.getText());
                System.out.println("Z      : " + zTextField.getText());
                System.out.println("Mass   : " + massTextField.getText());
                System.out.println("Lumin  : " + lumTextField.getText());
                System.out.println("Temper : " + tempTextField.getText());
                System.out.println("Period : " + periodTextField.getText());
                
                
                 
  
  BufferedReader br = null; 
  FileWriter writer = null;
  
  
                try {
                    br = new BufferedReader(new FileReader(realFile));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FxWindowTest.class.getName()).log(Level.SEVERE, null, ex);
                }
  
      
                            
  String line;
  String oldContent = "";
  
  String oldX = "";
  String newX = "   RSP_X = " + xTextField.getText();
  
                try {
                    while ((line = br.readLine()) != null) {
                        oldContent = oldContent + line + System.lineSeparator();
                        if(line.contains("RSP_X = ") ){
                             oldX = line;
                        }
                    }
                                           
                           newX = oldContent.replaceAll(oldX, newX);
                           writer = new FileWriter(realFile);
                           writer.write(newX);
                           writer.close();    
                    
                    
                    
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(FxWindowTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
                /*
                 try {
                    while (br.readLine().contains("x: ")) 
                        System.out.println(br.readLine());
                } catch (IOException ex) {
                    Logger.getLogger(FxWindowTest.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                      try {
                              writer = new FileWriter(file);
                            } catch (IOException ex) {
                                 Logger.getLogger(FxWindowTest.class.getName()).log(Level.SEVERE, null, ex);
                            }
                      
                            
                            writer.write("x: " + xTextField.getText());
                            
                            writer.close();
                            
                */
            }
        });
        
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(5);
        layout.setVgap(5);
        layout.setPadding(new Insets(5,5,5,5));
        
        layout.add(scenetitle, 0, 0);
        
        layout.add(modelName, 0, 2);
        layout.add(modelTextField,1,2);
        
        layout.add(x, 0, 3);
        layout.add(xTextField,1,3);
        
        layout.add(z, 0, 4);
        layout.add(zTextField,1,4);
        
        layout.add(mass, 0, 5);
        layout.add(massTextField,1,5);
        
        layout.add(lum, 0, 6);
        layout.add(lumTextField,1,6);
          
        layout.add(temp, 0, 7);
        layout.add(tempTextField,1,7);
        
        layout.add(period, 0, 8);
        layout.add(periodTextField,1,8);
        
        
        layout.add(btn,1,10);
              
        Scene scene = new Scene(layout, 750, 500);
        
        primaryStage.setTitle("Hydro Dynamic Radio Pulsar System?!");
        primaryStage.setScene(scene);
        
        scene.getStylesheets().add
                (FxWindowTest.class.getResource("cssTest.css").toExternalForm());
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}


/*
CSS SCRAPS (COULDNT COMMENT OUT IN CSS FILE)

.button {
    -fx-text-fill: white;
    -fx-font-family: "Arial Narrow";
    -fx-font-weight: bold;
    -fx-background-color: linear-gradient(#61a2b1, #2A5058);
    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5,0,0,1);
}

*/
