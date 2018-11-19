package addImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class addImage {
    private JPanel panelMain;
    private JButton btn_lanzar;
    private JLabel lbl_cara;
    private JLabel lbl_cruz;
    private JLabel lbl_moneda;

    Random random = new Random();
    int countcara = 0;
    int countcruz = 0;


//    ImageIcon b = new ImageIcon("cruz.png");
//    Image img2 = b.getImage();
//    Image reImagen2 = img2.getScaledInstance(caraocruz.getWidth(), caraocruz.getHeight(), 0);
//    Icon aux;

    public addImage() {
        btn_lanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                ImageIcon cara = new ImageIcon("cara.png");
                Image cara2 = cara.getImage();

                ImageIcon cruz = new ImageIcon("cruz.png");
                Image cruz2 = cruz.getImage();

                if(random.nextInt(2) == 0){
                    lbl_moneda.setIcon(new ImageIcon(cara2));
                    countcara++;
                }
                else{

                    lbl_moneda.setIcon(new ImageIcon(cruz2));
                    countcruz++;
                }

                lbl_cara.setText("Cara: "+countcara);
                lbl_cruz.setText("Cruz: "+countcruz);
            }
        });
    }

    public static void main(String[]args){
        JFrame frame = new JFrame("ap11");
        frame.setContentPane(new addImage().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(400, 500);
    }
}
