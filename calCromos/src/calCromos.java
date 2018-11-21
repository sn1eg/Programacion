import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;


public class calCromos {
    private JPanel panelMain;
    private JMenuBar menuBar;
    private JPanel panelRight;
    private JMenuItem itemComprar;
    private JPanel panelCromos;
    private JTextField txtBolsa1;
    private JTextField txtBolsa2;
    private JTextField txtBolsa3;
    private JMenuItem itemRepetidos;
    private JMenuItem itemPendientes;
    private JMenuItem itemCambiar;
    private JPanel panelCambiar;
    private JButton butCambiar;
    static int cromos = 20;

    public calCromos() {
        //https://stackoverflow.com/questions/9639017/intellij-gui-creator-jpanel-gives-runtime-null-pointer-exception-upon-adding-an
        GridBagConstraints txtConstraints = new GridBagConstraints();
        GridBagConstraints lblConstraints = new GridBagConstraints();
        for (int i = 0; i < cromos; i++) {
            JLabel lblCromo = new JLabel();
            lblConstraints.gridx = 0;
            lblConstraints.gridy = i;
            lblCromo.setText(String.valueOf(i));
            panelRight.add(lblCromo, lblConstraints);

            JTextField txtCromo = new JTextField();
            String nombre = "txtCromo" + i;
            txtConstraints.gridx = 0;
            txtConstraints.gridy = i;
            txtCromo.setPreferredSize(new Dimension(60, 24));
            txtCromo.setText("0");
            txtCromo.setName(nombre);
            panelRight.add(txtCromo, txtConstraints);
        }
        panelRight.validate();

        itemComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomNum1 = ThreadLocalRandom.current().nextInt(1, cromos);
                int randomNum2 = ThreadLocalRandom.current().nextInt(1, cromos);
                int randomNum3 = ThreadLocalRandom.current().nextInt(1, cromos);
                String nombre1 = "txtCromo" + randomNum1;
                String nombre2 = "txtCromo" + randomNum2;
                String nombre3 = "txtCromo" + randomNum3;
                for (Component c : panelRight.getComponents()) {
                    compraCromo(c,nombre1,randomNum1,txtBolsa1);
                    compraCromo(c,nombre2,randomNum2,txtBolsa2);
                    compraCromo(c,nombre3,randomNum3,txtBolsa3);
                    /*if (c.getName() != null && c.getName().equals(nombre1)) {
                        JTextField txtCromo = (JTextField) c;
                        int n1 = Integer.parseInt(txtCromo.getText()) + 1;
                        txtCromo.setText(String.valueOf(n1));
                        System.out.println(c.getName() + " " + String.valueOf(n1));
                        panelRight.validate();
                    }
                    if (c.getName() != null && c.getName().equals(nombre2)) {
                        JTextField txtCromo = (JTextField) c;
                        int n2 = Integer.parseInt(txtCromo.getText()) + 1;
                        txtCromo.setText(Integer.toString(n2));
                        panelRight.validate();
                    }
                    if (c.getName() != null && c.getName().equals(nombre3)) {
                        JTextField txtCromo = (JTextField) c;
                        int n3 = Integer.parseInt(txtCromo.getText()) + 1;
                        txtCromo.setText(Integer.toString(n3));
                        panelRight.validate();
                    }*/
                }
                //txtBolsa1.setText(String.valueOf(randomNum1));
                //txtBolsa2.setText(String.valueOf(randomNum2));
                //txtBolsa3.setText(String.valueOf(randomNum3));
            }
            // ---> compraCromo(c,nombre2,random2,txtBolsa2);
            private void compraCromo(Component c,String nombre, int randomNum, JTextField txtBolsa) {
                if (c.getName() != null && c.getName().equals(nombre)) {
                    JTextField txtCromo = (JTextField) c;
                    int n = Integer.parseInt(txtCromo.getText()) + 1;
                    txtCromo.setText(String.valueOf(n));
                    txtBolsa.setText(String.valueOf(randomNum));
                    txtBolsa.setEditable(false);
                    panelRight.validate();
                }
            }
        });
        itemRepetidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Component c : panelRight.getComponents()) {
                    if (c.getName() != null) {
                        JTextField txtCromo = (JTextField) c;
                        if (Integer.parseInt(txtCromo.getText()) > 1) {
                            txtCromo.setBackground(Color.red);
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Colección de cromos");
        frame.setPreferredSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new calCromos().panelMain);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
