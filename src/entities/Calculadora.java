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
        }
    }

    
}
