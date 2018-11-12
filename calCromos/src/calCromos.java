import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class calCromos {
    private JPanel panelMain;
    private JMenuBar menuBar;
    private JPanel panelRight;
    private JMenuItem itemComprar;
    static int cromos = 50;

    public calCromos() {
        //https://stackoverflow.com/questions/9639017/intellij-gui-creator-jpanel-gives-runtime-null-pointer-exception-upon-adding-an
        GridBagConstraints txtConstraints = new GridBagConstraints();
        GridBagConstraints lblConstraints = new GridBagConstraints();
        for (int i=0;i<cromos;i++) {
            JTextField txtCromo = new JTextField();
            JLabel lblCromo = new JLabel();

            lblConstraints.gridx = i;
            lblConstraints.gridy = 0;

            txtConstraints.gridx = 0;
            txtConstraints.gridy = i;

            txtCromo.setPreferredSize(new Dimension(60, 24));
            lblCromo.setPreferredSize(new Dimension(70, 24));

            txtCromo.setText("0");
            lblCromo.setText("Cromo " + i);

            txtCromo.setName("txtCromo" + i);


            panelRight.add(lblCromo, lblConstraints);
            panelRight.add(txtCromo, txtConstraints);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Colección de cromos");
        // frame.setPreferredSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new calCromos().panelMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
