package calculadorapoo;

/*
Ficou com um monte de import a mais de tentatias de fazer ler somente numeros pelo teclado...
*/

import java.awt.Button;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tela extends JFrame implements ActionListener, WindowListener{

    protected Dimension dFrame, dLabel, dTextField, dButton, dTextArea;
    protected JTextField txtVisor;
    protected Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0,
            btDelBack, btClr, btIgual, btSoma, btSubtrai, btDiv, btMult;
    private Operacao operacao;
    private String linha;

    public Tela() {
        operacao = new Operacao();
        linha = "";

        //Aparencia da tela        
        dFrame = new Dimension(280, 450);
        dTextField = new Dimension(230, 40);
        dButton = new Dimension(50, 50);
        dTextArea = new Dimension(300, 140);

        this.setTitle("Mouse Calc");
        this.setResizable(false);
        this.setSize(dFrame);
        this.setLayout(null);

        /*Não consegui encontrar um método para deixar digitar somente os números.
        Não consegui fazer o KeyListener funcionar....
        Então ela só deve funcionar pelo mouse. por isso usei txtVisor.setEditable(false);
         */
        txtVisor = new JTextField(null);
        txtVisor.setSize(dTextField);
        txtVisor.setLocation(20, 20);
        txtVisor.setHorizontalAlignment(JTextField.RIGHT);
        txtVisor.setBackground(Color.white);
        txtVisor.setFont(txtVisor.getFont().deriveFont(24f));
        txtVisor.setEditable(false);
        this.add(txtVisor);

        bt7 = new Button("7");
        bt7.setSize(dButton);
        bt7.setFont(txtVisor.getFont().deriveFont(20f));
        bt7.setLocation(20, 150);
        bt7.addActionListener(this);
        this.add(bt7);

        bt8 = new Button("8");
        bt8.setSize(dButton);
        bt8.setFont(txtVisor.getFont().deriveFont(20f));
        bt8.setLocation(80, 150);
        bt8.addActionListener(this);
        this.add(bt8);

        bt9 = new Button("9");
        bt9.setSize(dButton);
        bt9.setFont(txtVisor.getFont().deriveFont(20f));
        bt9.setLocation(140, 150);
        bt9.addActionListener(this);
        this.add(bt9);

        btDiv = new Button("/");
        btDiv.setSize(dButton);
        btDiv.setFont(txtVisor.getFont().deriveFont(20f));
        btDiv.setLocation(200, 150);
        btDiv.addActionListener(this);
        this.add(btDiv);

        bt4 = new Button("4");
        bt4.setSize(dButton);
        bt4.setFont(txtVisor.getFont().deriveFont(20f));
        bt4.setLocation(20, 210);
        bt4.addActionListener(this);
        this.add(bt4);

        bt5 = new Button("5");
        bt5.setSize(dButton);
        bt5.setFont(txtVisor.getFont().deriveFont(20f));
        bt5.setLocation(80, 210);
        bt5.addActionListener(this);
        this.add(bt5);

        bt6 = new Button("6");
        bt6.setSize(dButton);
        bt6.setFont(txtVisor.getFont().deriveFont(20f));
        bt6.setLocation(140, 210);
        bt6.addActionListener(this);
        this.add(bt6);

        btMult = new Button("*");
        btMult.setSize(dButton);
        btMult.setFont(txtVisor.getFont().deriveFont(20f));
        btMult.setLocation(200, 210);
        btMult.addActionListener(this);
        this.add(btMult);

        bt1 = new Button("1");
        bt1.setSize(dButton);
        bt1.setFont(txtVisor.getFont().deriveFont(20f));
        bt1.setLocation(20, 270);
        bt1.addActionListener(this);
        this.add(bt1);

        bt2 = new Button("2");
        bt2.setSize(dButton);
        bt2.setFont(txtVisor.getFont().deriveFont(20f));
        bt2.setLocation(80, 270);
        bt2.addActionListener(this);
        this.add(bt2);

        bt3 = new Button("3");
        bt3.setSize(dButton);
        bt3.setFont(txtVisor.getFont().deriveFont(20f));
        bt3.setLocation(140, 270);
        bt3.addActionListener(this);
        this.add(bt3);

        btSubtrai = new Button("-");
        btSubtrai.setSize(dButton);
        btSubtrai.setFont(txtVisor.getFont().deriveFont(20f));
        btSubtrai.setLocation(200, 270);
        btSubtrai.addActionListener(this);
        this.add(btSubtrai);

        btDelBack = new Button("DEL");
        btDelBack.setSize(dButton);
        btDelBack.setFont(txtVisor.getFont().deriveFont(20f));
        btDelBack.setLocation(20, 330);
        btDelBack.addActionListener(this);
        this.add(btDelBack);

        bt0 = new Button("0");
        bt0.setSize(dButton);
        bt0.setFont(txtVisor.getFont().deriveFont(20f));
        bt0.setLocation(80, 330);
        bt0.addActionListener(this);
        this.add(bt0);

        btIgual = new Button("=");
        btIgual.setSize(dButton);
        btIgual.setFont(txtVisor.getFont().deriveFont(20f));
        btIgual.setLocation(140, 330);
        btIgual.addActionListener(this);
        this.add(btIgual);

        btSoma = new Button("+");
        btSoma.setSize(dButton);
        btSoma.setFont(txtVisor.getFont().deriveFont(20f));
        btSoma.setLocation(200, 330);
        btSoma.addActionListener(this);
        this.add(btSoma);

        btClr = new Button("CLR");
        btClr.setSize(dButton);
        btClr.setFont(txtVisor.getFont().deriveFont(20f));
        btClr.setLocation(200, 90);
        btClr.addActionListener(this);
        this.add(btClr);

        //adicionar o Windowlistener
        this.addWindowListener(this);
        txtVisor.setText("0");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            linha += "1";
            txtVisor.setText(linha);
        }
        if (e.getSource() == bt2) {
            linha += "2";
            txtVisor.setText(linha);
        }
        if (e.getSource() == bt3) {
            linha += "3";
            txtVisor.setText(linha);
        }
        if (e.getSource() == bt4) {
            linha += "4";
            txtVisor.setText(linha);
        }
        if (e.getSource() == bt5) {
            linha += "5";
            txtVisor.setText(linha);
        }
        if (e.getSource() == bt6) {
            linha += "6";
            txtVisor.setText(linha);
        }
        if (e.getSource() == bt7) {
            linha += "7";
            txtVisor.setText(linha);
        }
        if (e.getSource() == bt8) {
            linha += "8";
            txtVisor.setText(linha);
        }
        if (e.getSource() == bt9) {
            linha += "9";
            txtVisor.setText(linha);
        }
        if (e.getSource() == bt0) {
            linha += "0";
            txtVisor.setText(linha);
        }

        if (e.getSource() == btClr) {
            operacao.setOper(0);
            operacao.setValor(0);
            linha = "";
            txtVisor.setText("0");
        }

        if (e.getSource() == btDelBack) {
            linha = linha.substring(0, (linha.length()) - 1);
            txtVisor.setText(linha);
        }
        if (e.getSource() == btIgual) {
            resolve();
            linha="";
            operacao.setOper(0);
            operacao.setValor(0);
        }
        if (e.getSource() == btSoma) {
            if (operacao.getOper() != 0) {
                resolve();
            } else {
                operacao.setValor(Double.parseDouble(txtVisor.getText()));
            }
            operacao.setOper(1);
            preencheVisor();
        }
        if (e.getSource() == btSubtrai) {
            if (operacao.getOper() != 0) {
                resolve();
            } else {
                operacao.setValor(Double.parseDouble(txtVisor.getText()));
            }
            operacao.setOper(2);
            preencheVisor();
        }
        if (e.getSource() == btMult) {
            if (operacao.getOper() != 0) {
                resolve();
            } else {
                operacao.setValor(Double.parseDouble(txtVisor.getText()));
            }
            operacao.setOper(3);
            preencheVisor();
        }

        if (e.getSource() == btDiv) {
            if (operacao.getOper() != 0) {
                resolve();
            } else {
                operacao.setValor(Double.parseDouble(txtVisor.getText()));
            }
            operacao.setOper(4);
            preencheVisor();
        }
    }

    /*
    não pude tirar a dúvida se o método deveria estar aqui ou na Classe Operacao...
    Funcao resolve calcula a operacao guardada anteriormente caso seja colocada
    outra operação ao invés de igual. p.ex. 3*3/2
    */
    public void resolve() {
        double valor = Double.parseDouble(txtVisor.getText());
        if (operacao.getOper() == 1) {
            operacao.setValor(operacao.soma(operacao.getValor(), valor));
        } else if (operacao.getOper() == 2) {
            operacao.setValor(operacao.subtracao(operacao.getValor(), valor));
        } else if (operacao.getOper() == 3) {
            operacao.setValor(operacao.multiplicacao(operacao.getValor(), valor));
        } else if (operacao.getOper() == 4) {
            if (valor == 0) {
                txtVisor.setText("Erro - divisão por 0!");
                return;//para evitar o preencheVisor, que pegaria o valor anterior ao 0.
            } else {
                operacao.setValor(operacao.divisao(operacao.getValor(), valor));
            }
        }
        preencheVisor();
    }
    /* 
    para não aparecer a casa decimal caso seja inteiro
    */
    private void preencheVisor() {
        linha="";
        if (operacao.getValor() % 1 == 0) {
            int intTxt = (int) operacao.getValor();
            txtVisor.setText(String.valueOf(intTxt));
        } else {
            txtVisor.setText(String.valueOf(operacao.getValor()));
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
