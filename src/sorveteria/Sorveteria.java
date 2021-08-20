package sorveteria;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.NumberFormat;

public class Sorveteria extends JFrame implements ActionListener {

    JLabel[] lblsabor = new JLabel[7];
    String sabor[] = {"Chocolate", "Morango", "Pistache", "Baunilha", "Uva", "Nutella", "Maracujá"};
    JLabel[] preco = new JLabel[7];
    double precodecada[] = {0.30, 0.20, 0.40, 0.90, 1.00, 2.00, 3.00};
    JLabel[] precounit = new JLabel[7];
    JLabel precofinal = new JLabel();
    JTextField[] qtd = new JTextField[7];
    JButton calc, limp;
    NumberFormat NF1;
    JLabel lblNomeSab, lblPrecoUnit, lblQntd, lblPrecoQntd, lblTotal;

    public static void main(String[] args) {

        JFrame janela = new Sorveteria();
        janela.setUndecorated(true);
        janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    Sorveteria() {

        setTitle("Compre um sorvete");
        setBounds(100, 100, 550, 480);
        getContentPane().setBackground(new Color(27, 193, 188));

        NF1 = NumberFormat.getNumberInstance();
        NF1.setMinimumFractionDigits(2);

        lblNomeSab = new JLabel("Sabor", javax.swing.SwingConstants.CENTER);
        lblPrecoUnit = new JLabel("Preço unitário", javax.swing.SwingConstants.CENTER);
        lblQntd = new JLabel("Quantidade", javax.swing.SwingConstants.CENTER);
        lblPrecoQntd = new JLabel("Preço", javax.swing.SwingConstants.CENTER);

        for (int i = 0; i < sabor.length; i++) {
            lblsabor[i] = new JLabel("" + sabor[i], javax.swing.SwingConstants.CENTER);
        }

        for (int i = 0; i < preco.length; i++) {
            preco[i] = new JLabel("R$ " + NF1.format(precodecada[i]), javax.swing.SwingConstants.CENTER);
        }

        for (int i = 0; i <= 6; i++) {
            qtd[i] = new JTextField();
        }

        for (int i = 0; i < preco.length; i++) {
            precounit[i] = new JLabel("", javax.swing.SwingConstants.CENTER);
        }

        getContentPane().setLayout(new GridLayout(9, 4));

        getContentPane().add(lblNomeSab);
        getContentPane().add(lblPrecoUnit);
        getContentPane().add(lblQntd);
        getContentPane().add(lblPrecoQntd);

        for (int i = 0; i <= 6; i++) {
            getContentPane().add(lblsabor[i]);
            getContentPane().add(preco[i]);
            getContentPane().add(qtd[i]);
            getContentPane().add(precounit[i]);
        }

        calc = new JButton("Calcular");
        calc.addActionListener(this);
        getContentPane().add(calc);

        limp = new JButton("Limpar");
        limp.addActionListener(this);
        getContentPane().add(limp);

        lblTotal = new JLabel("Total:", javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblTotal);

        precofinal = new JLabel("", javax.swing.SwingConstants.CENTER);
        getContentPane().add(precofinal);
    }
    double[] quant = new double[7];
    double[] valor = new double[7];
    double total;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calc) {
            try {
                for (int i = 0; i < qtd.length; i++) {
                    if (qtd[i].getText().length() != 0) {
                        quant[i] = Double.parseDouble(qtd[i].getText());
                        valor[i] = quant[i] * precodecada[i];
                        precounit[i].setText("R$ " + NF1.format(valor[i]));
                        total += valor[i];
                        precofinal.setText("R$ " + NF1.format(total));
                    }
                }
            } catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(null, "Caro usuário, digite somente números",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == limp) {
            for (int i = 0; i < qtd.length; i++) {
                qtd[i].setText(" ");
                precounit[i].setText(" ");
                precofinal.setText(" ");
            }
        }
    }
}
