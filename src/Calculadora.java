import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Virgilio Chiboleca
 */
public class Calculadora implements ActionListener{
    
    JFrame frame;
    JTextField textfield;
    JButton[] numeroBotoes = new JButton[10];
    JButton[] botoesFuncoes = new JButton[12];
    JButton botaoMais, botaoMenos, botaoMultiplicacao, botaoDivisao, botaoExp, botaoModulo, botaoFact;
    JButton botaoDec, botaoIgual, botaoApagar, botaoLimpar, botaoNegativo;
    JPanel painel;
    
    Font fonte = new Font("Ink Free", Font.BOLD,30);
    
    double num1 = 0, num2 = 0, resultado = 0;
    char operador;
    
    public Calculadora() {
        
        frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 650);
        frame.setLayout(null);
        
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(fonte);
        textfield.setEditable(false);
        
        botaoMais = new JButton("+");
        botaoMenos = new JButton("-");
        botaoMultiplicacao = new JButton("X");
        botaoDivisao = new JButton("/");
        botaoExp = new JButton("^");
        botaoModulo = new JButton("Mod");
        botaoDec = new JButton(".");
        botaoIgual = new JButton("=");
        botaoApagar = new JButton("Del");
        botaoLimpar = new JButton("C");
        botaoNegativo = new JButton("(-)");
        botaoFact = new JButton("Fac");
        
        
        botoesFuncoes[0] = botaoMais;
        botoesFuncoes[1] = botaoMenos;
        botoesFuncoes[2] = botaoMultiplicacao;
        botoesFuncoes[3] = botaoDivisao;
        botoesFuncoes[4] = botaoExp;
        botoesFuncoes[5] = botaoModulo;
        botoesFuncoes[6] = botaoDec;
        botoesFuncoes[7] = botaoIgual;
        botoesFuncoes[8] = botaoApagar;
        botoesFuncoes[9] = botaoLimpar;
        botoesFuncoes[10] = botaoNegativo;
        botoesFuncoes[11] = botaoFact;
        
        
        for (int i = 0; i < 12; i++) {
            
            botoesFuncoes[i].addActionListener(this);
            botoesFuncoes[i].setFont(fonte);
            botoesFuncoes[i].setFocusable(false);
        }
        
        for (int i = 0; i < 10; i++) {
            
            numeroBotoes[i] = new JButton(String.valueOf(i));
            numeroBotoes[i].addActionListener(this);
            numeroBotoes[i].setFont(fonte);
            numeroBotoes[i].setFocusable(false);
        }
        
        botaoNegativo.setBounds(50, 500, 100, 50);
        botaoApagar.setBounds(150, 500, 100, 50);
        botaoLimpar.setBounds(250, 500, 100, 50);
        
        botaoExp.setBounds(50, 425, 100, 50);
        botaoModulo.setBounds(150, 425, 100, 50);
        botaoFact.setBounds(250, 425, 100, 50);
        
        painel = new JPanel();
        painel.setBounds(50, 100, 300, 300);
        painel.setLayout(new GridLayout(4,4,10,10));
        
        painel.add(numeroBotoes[1]);
        painel.add(numeroBotoes[2]);
        painel.add(numeroBotoes[3]);
        painel.add(botaoMais);
        
        painel.add(numeroBotoes[4]);
        painel.add(numeroBotoes[5]);
        painel.add(numeroBotoes[6]);
        painel.add(botaoMenos);
        
        painel.add(numeroBotoes[7]);
        painel.add(numeroBotoes[8]);
        painel.add(numeroBotoes[9]);
        painel.add(botaoMultiplicacao);
        painel.add(botaoDec);
        painel.add(numeroBotoes[0]);
        painel.add(botaoIgual);
        painel.add(botaoDivisao);
        
        frame.add(painel);
        frame.add(botaoNegativo);
        frame.add(botaoApagar);
        frame.add(botaoLimpar);
        frame.add(botaoFact);
        frame.add(botaoExp);
        frame.add(botaoModulo);
        frame.add(textfield);
        frame.setVisible(true);
                
        
        
        frame.add(textfield);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numeroBotoes[i]) {
                
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
                
            }
        }
        if (e.getSource() == botaoDec) {
            
            textfield.setText(textfield.getText().concat("."));
        }
        
        if (e.getSource() == botaoMais) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '+';
            textfield.setText("");
        }
        
        if (e.getSource() == botaoMenos) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '-';
            textfield.setText("");
        }
        
        if (e.getSource() == botaoMultiplicacao) {
            num1 = Double.parseDouble(textfield.getText());
            operador = 'X';
            textfield.setText("");
        }
        
        if (e.getSource() == botaoDivisao) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '/';
            textfield.setText("");
        }
        
        if (e.getSource() == botaoModulo) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '%';
            textfield.setText("");
        }
        if (e.getSource() == botaoExp) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '^';
            textfield.setText("");
        }
        if (e.getSource() == botaoFact) {
            num1 = Double.parseDouble(textfield.getText());
            operador = '!';
            textfield.setText("");
        }
        
        if (e.getSource() == botaoIgual) {
            num2 = Double.parseDouble(textfield.getText());
            
            switch (operador) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case 'X':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(null, "Divisao por zero nao e possivel");
                    }
                    break;
                case '%':
                    resultado = num1 % num2;
                    break;
                case '^':
                    resultado = Math.pow(num1, num2);
                    break;
                case '!':
                    int factorial = 1;
                    
                    for (int i = 1; i <= num1; i++) {
                        factorial *= i;
                    }
                   
                    resultado = factorial;
                    break;
            }
            
            textfield.setText(String.valueOf(resultado));
            num1 = resultado;
        }
        if (e.getSource() == botaoLimpar) {
            textfield.setText("");
        }
        if (e.getSource() == botaoApagar) {
            String string = textfield.getText();
            textfield.setText("");
            
            for (int i = 0; i < string.length()-1; i++) {
                
                textfield.setText(textfield.getText() + string.charAt(i));
                
            }
        }
        if (e.getSource() == botaoNegativo) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
