package org.mconcoba.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 *
 * @author mconcoba
 */
public class CalculatorController implements Initializable {
    
 
   private double number1;
   private String operator = "";
   private boolean start = true;
    
    @FXML private TextField txtValores;
    @FXML private Label txtOpt;
    @FXML private Label txtH;
    @FXML private Button btnMenos;
    @FXML private Button btnMas;
    @FXML private Button btnMult;
    @FXML private Button btnDiv;
    @FXML private Button btnRaiz;
    @FXML private Button btnPotencia;
    @FXML private Button btnPor;
    @FXML private Button btnUnoX;
    @FXML private Button btnMM;
    @FXML private Button btnPunto;
    @FXML private Button btnAC;
    @FXML private Button btnC;
    @FXML private Button btnIgual;
    @FXML private Button btn0;
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    @FXML private Button btn7;
    @FXML private Button btn8;
    @FXML private Button btn9;    
    


    
    @FXML
    private void processNumPad(ActionEvent event){
        if(txtOpt.getText().equals("ERROR")){
            txtOpt.setText("");;
        }
        if(start){
            txtOpt.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        txtOpt.setText(txtOpt.getText() + value);
    }
    
    @FXML
    private void processOperator(ActionEvent event){
        if(txtOpt.getText().equals("ERROR")){
            return;
        }
        String value = ((Button) event.getSource()).getText(); 
        if(value.equals("=")){
            
            if(operator.isEmpty()){
                return;
            }
            if(txtOpt.getText().isEmpty()){
                txtOpt.setText("ERROR");
                operator = "";
                start = true;
                return;
            }
            txtH.setText(txtH.getText() +  Float.parseFloat(txtOpt.getText()) + " =");
            txtOpt.setText(calculate(number1, Float.parseFloat(txtOpt.getText()), operator));
            operator = "";
            //start = true;
            
            
        } else if(value.equals("+/-")){
              number1 = Double.parseDouble(txtOpt.getText());
             txtOpt.setText(String.valueOf(number1 * -1));
            
        } else {
            if(!operator.isEmpty()) {
                return;
            } else {
                operator = value;
                number1 = Double.parseDouble(txtOpt.getText());
                txtH.setText(String.valueOf(number1) + " " + operator + " ");
                txtOpt.setText("");
            }
        }
    }
    
    @FXML
    private void clearTxt(ActionEvent event){
        txtOpt.setText("0");
        txtH.setText("");
        start = true;
        operator = "";
    }
    
     @FXML
    private void clearTxtLast(ActionEvent event){
        if(txtOpt.getText().length() > 0){
           String str = txtOpt.getText();	
           str = str.replaceFirst(".$","");
           txtOpt.setText(str);
        } else {
            txtOpt.setText("0");
            
        }
        
    }
    
    
    
    
    private String calculate(double number1, double number2, String opt){
        switch(opt){
            case "+":
                return String.valueOf(number1 + number2);
            case "-":
                return String.valueOf(number1 - number2);
            case "×":
                return String.valueOf(number1 * number2);
            case "÷":
                if(number2 == 0){
                    return "ERROR";
                }
                return String.valueOf(number1 / number2);
          
        }
        
        return "ERROR";
    }
    
    boolean isInteger(float number){
        int x = (int)number;
        float temp2 = number - x;
        
        if(temp2 > 0){
            return false;
        }
        return true;
    
    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
