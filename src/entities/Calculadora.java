package entities;
import java.awt.*;
import java.awt.event.*;
import  java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculadora {
    int boardWidth=360;
    int boardHeight=540;

    Color Lightpink =new Color(255,182,193);
    Color White =new Color(255,255,255);
    Color Pink =new Color(239,111,130);
    Color Ciano =new Color(16,144,125);
    Color CianoEscuro =new Color(23,105,93);

    String[] buttonValues ={
        "C","()","%","/",
        "7","8","9","*",
        "4","5","6","-",
        "1","2","3","+",
        "+/-","0",".","=",
    };
    String[] rightSymbols ={"/","*","-","+","="};
    String[] topSymbols ={"C","()","%"};


    JFrame frame = new JFrame("Calculadora");
    JLabel displayLabel =new JLabel();
    JPanel displayPanel= new JPanel();

    JPanel buttonsPanel = new JPanel();

    String nm1="0";
    String op=null;
    String nm2="0";


    public Calculadora(){
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        displayLabel.setBackground(Lightpink);
        displayLabel.setForeground(White);
        displayLabel.setFont(new Font("PinionScript", Font.PLAIN,80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel,BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5,4) );
        buttonsPanel.setBackground(Lightpink);
        frame.add(buttonsPanel);

        for(int i=0; i<buttonValues.length; i++){
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial",Font.PLAIN,30));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(Lightpink));
            

            if(Arrays.asList(topSymbols).contains(buttonValue)){
                button.setBackground(Ciano);
                button.setForeground(White);
            } else if(Arrays.asList(rightSymbols).contains(buttonValue)){
                button.setBackground(CianoEscuro);
                button.setForeground(White);
            }else{
                button.setBackground(Pink);
                button.setForeground(White);
            }
            buttonsPanel.add(button);

            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JButton button =(JButton) e.getSource();
                    String buttonValue = button.getText();
                    if (Arrays.asList(rightSymbols).contains(buttonValue)){
                        if (buttonValue == "=") {
                    
                        }else if("/*-+".contains(buttonValue)){
                            if(op==null){
                                
                            }
                        }else{

                        }
                    }else if (Arrays.asList(topSymbols).contains(buttonValue)){
                        if (buttonValue == "C") {
                            clearAll();
                            displayLabel.setText("0");
                            
                        }else if(buttonValue == "()"){
                            //procurar como fazer

                        }else if(buttonValue == "%"){
                            double numDisplay =Double.parseDouble(displayLabel.getText());
                            numDisplay /= 100;
                            displayLabel.setText(remove0decimal(numDisplay));

                        }
                    }else {
                        if(buttonValue == "."){
                            if(displayLabel.getText().contains(buttonValue)){
                                displayLabel.setText(displayLabel.getText() + buttonValue);   
                            //deu erro
                            }

                        }else if("0123456789".contains(buttonValue)){
                            if (displayLabel.getText()=="0"){
                                displayLabel.setText(buttonValue);

                            }else{
                                displayLabel.setText(displayLabel.getText()+buttonValue);
                            }
                        }else{
                            //case +/-
                            double numDisplay =Double.parseDouble(displayLabel.getText());
                            numDisplay*= -1;
                            displayLabel.setText(remove0decimal(numDisplay));
                        }

                    }
                }
            });
        }
    }
    void clearAll(){
        nm1 ="0";
        op= null;
        nm2="0";
    }
    String remove0decimal(double numDisplay){
        if(numDisplay %1 == 0){
            return Integer.toString((int) numDisplay);
        }
        return Double.toString(numDisplay);
    }
    
}
