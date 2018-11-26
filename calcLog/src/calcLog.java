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
    String resultado2 = "";
    int total = 0;


    //Se imprimen los valores, respetando el contenido anterior del text area
    public void imprimir() {
            txtarea_log.append(resultado2 + "\n");
            txt_result.setText(total+"");
        }

    //Recogida de los numeros y casteo a int
    public void recoger(){
        num1 = Integer.parseInt(txt_num1.getText());
        num2 = Integer.parseInt(txt_num2.getText());
    }



    public void suma(){
        resultado = num1+num2;
        total = total + resultado;
        resultado2 = num1 +"+"+num2+"= "+resultado;

    }

    public void resta(){
        resultado = num1-num2;
        total = total + resultado;
        resultado2 = num1 +"-"+num2+"= "+resultado;

    }

    public void multiplicacion(){
        resultado = num1*num2;
        total = total + resultado;
        resultado2 = num1 +"*"+num2+"= "+resultado;

    }

    public void division(){
        resultado = num1/num2;
        total = total + resultado;
        resultado2 = num1 +"/"+num2+"= "+resultado;

    }

    public calcLog() {
        btn_sum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recoger();
                suma();
                imprimir();
            }
        });
        btn_res.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recoger();
                resta();
                imprimir();
            }
        });
        btn_mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recoger();
                multiplicacion();
                imprimir();
            }
        });
        btn_div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                recoger();
                division();
                imprimir();
            }
        });
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
