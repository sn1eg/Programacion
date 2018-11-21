import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calcLog {
    private JPanel mainPanel;
    private JPanel numPanel;
    private JPanel operatorPanel;
    private JPanel logPanel;
    private JTextField txt_num1;
    private JTextField txt_num2;
    private JTextArea txtarea_log;
    private JButton btn_sum;
    private JButton btn_div;
    private JButton btn_res;
    private JButton btn_mul;
    private JLabel lbl_num1;
    private JLabel lbl_num2;
    private JTextField txt_result;

    int num1 = 0;
    int num2 = 0;
    int resultado = 0;


    //Recogida de los numeros y casteo a int
    ActionListener recoger = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            num1 = Integer.parseInt(txt_num1.getText());
            num2 = Integer.parseInt(txt_num2.getText());
        }
    };

    //Se imprimen los valores, respetando el contenido anterior del text area
    ActionListener imprimir = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtarea_log.append(resultado + "\n");
            txt_result.setText(resultado+"");
        }
    };

    ActionListener suma = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultado = num1+num2;
        }
    };

    public void recoger(){
        num1 = Integer.parseInt(txt_num1.getText());
        num2 = Integer.parseInt(txt_num2.getText());
    }


    public calcLog() {
//        btn_sum.addActionListener(recoger);
        btn_sum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        btn_sum.addActionListener(suma);
        btn_sum.addActionListener(imprimir);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ap11");
        frame.setContentPane(new calcLog().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
        frame.setSize(550, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
