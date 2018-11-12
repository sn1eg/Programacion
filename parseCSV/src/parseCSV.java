import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class parseCSV {
    private JPanel panelMain;
    private JTextField txtBuscar;
    private JButton butBuscar;
    private JTextArea txtProductos;
    private JPanel panelRight;
    private JTextField txt_id2;
    private JTextField txt_id3;
    private JTextField txt_nombre1;
    private JTextField txt_nombre2;
    private JTextField txt_nombre3;
    private JTextField txt_cant1;
    private JTextField txt_cant2;
    private JTextField txt_cant3;
    private JTextField txt_precio1;
    private JTextField txt_precio2;
    private JTextField txt_precio3;
    private JTextField txt_importe1;
    private JTextField txt_importe2;
    private JTextField txt_importe3;
    private JTextField txt_importetotal;
    private JTextField txt_id1;
    public static final int n = 77;
    static int[] idProducto = new int[n];
    static String[] nombre = new String[n];
    static String[] categoria = new String[n];
    static String[] presentacion = new String[n];
    static String[] precio = new String[n];


    public parseCSV() {
        butBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = txtBuscar.getText();
                String result = "";
                /*for (int i = 0; i < n; i++) {
                    System.out.println(idProducto[i] + " " + nombre[i] + " " + categoria[i]);
                }*/
                if (str != null && !str.isEmpty()) {
                    //for (String nom : nombre) {
                    for (int z = 0; z < nombre.length; z++) {
                        //nom = nom.toLowerCase();
                        //str = str.toLowerCase();
                        if (Pattern.compile(Pattern.quote(str), Pattern.CASE_INSENSITIVE).matcher(nombre[z]).find()) {
                            result += idProducto[z]+" - "+nombre[z]+"\n";
                        }
                    }
                    if (result.isEmpty()) {
                        result = "No encontrado!!!";
                    }
                    txtProductos.setText(result);
                }
            }
        });

        txt_id1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                for(int f = 0; f < idProducto.length; f++){
                    if(Integer.parseInt(txt_id1.getText()) == idProducto[f]){
                        txt_nombre1.setText(nombre[f]);
                        txt_precio1.setText(precio[f]);
                    }
                }
            }
        });

        txt_id2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                for(int f = 0; f < idProducto.length; f++){
                    if(Integer.parseInt(txt_id2.getText()) == idProducto[f]){
                        txt_nombre2.setText(nombre[f]);
                        txt_precio2.setText(precio[f]);
                    }
                }
            }
        });

        txt_id3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                for(int f = 0; f < idProducto.length; f++){
                    if(Integer.parseInt(txt_id3.getText()) == idProducto[f]){
                        txt_nombre3.setText(nombre[f]);
                        txt_precio3.setText(precio[f]);
                    }
                }
            }
        });

        txt_cant1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                float aux1 = Float.parseFloat(txt_precio1.getText().charAt(0) +""+ txt_precio1.getText().charAt(1));
                int aux2 = Integer.parseInt(txt_precio1.getText().charAt(3) +""+ txt_precio1.getText().charAt(4));
                float aux3 = 0;
                aux3 = (float) (aux2 * 0.01);
                float cant = 0;
                cant = Float.parseFloat(txt_cant1.getText());

                float total = 0;
                total = cant*(aux1+aux3);


                float aux4 = Float.parseFloat(txt_precio2.getText().charAt(0) +""+ txt_precio2.getText().charAt(1));
                int aux5 = Integer.parseInt(txt_precio2.getText().charAt(3) +""+ txt_precio2.getText().charAt(4));
                float aux6 = 0;
                aux6 = (float) (aux5 * 0.01);
                float cant2 = 0;
                cant = Float.parseFloat(txt_cant2.getText());

                float total2 = 0;
                total2 = cant*(aux4+aux6);


                float aux7 = Float.parseFloat(txt_precio3.getText().charAt(0) +""+ txt_precio3.getText().charAt(1));
                int aux8 = Integer.parseInt(txt_precio3.getText().charAt(3) +""+ txt_precio3.getText().charAt(4));
                float aux9 = 0;
                aux6 = (float) (aux8 * 0.01);
                float cant3 = 0;
                cant = Float.parseFloat(txt_cant3.getText());

                float total3 = 0;
                total3 = cant*(aux7+aux9);

                txt_importe1.setText(total+"");
                txt_importe2.setText(total2+"");
                txt_importe3.setText(total3+"");

                txt_importetotal.setText(total+total2+total3+"");


            }
        });

        txt_cant2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                float aux1 = Float.parseFloat(txt_precio1.getText().charAt(0) +""+ txt_precio1.getText().charAt(1));
                int aux2 = Integer.parseInt(txt_precio1.getText().charAt(3) +""+ txt_precio1.getText().charAt(4));
                float aux3 = 0;
                aux3 = (float) (aux2 * 0.01);
                float cant = 0;
                cant = Float.parseFloat(txt_cant1.getText());

                float total = 0;
                total = cant*(aux1+aux3);


                float aux4 = Float.parseFloat(txt_precio2.getText().charAt(0) +""+ txt_precio2.getText().charAt(1));
                int aux5 = Integer.parseInt(txt_precio2.getText().charAt(3) +""+ txt_precio2.getText().charAt(4));
                float aux6 = 0;
                aux6 = (float) (aux5 * 0.01);
                float cant2 = 0;
                cant = Float.parseFloat(txt_cant2.getText());

                float total2 = 0;
                total2 = cant*(aux4+aux6);


                float aux7 = Float.parseFloat(txt_precio3.getText().charAt(0) +""+ txt_precio3.getText().charAt(1));
                int aux8 = Integer.parseInt(txt_precio3.getText().charAt(3) +""+ txt_precio3.getText().charAt(4));
                float aux9 = 0;
                aux6 = (float) (aux8 * 0.01);
                float cant3 = 0;
                cant = Float.parseFloat(txt_cant3.getText());

                float total3 = 0;
                total3 = cant*(aux7+aux9);

                txt_importe1.setText(total+"");
                txt_importe2.setText(total2+"");
                txt_importe3.setText(total3+"");

                txt_importetotal.setText(total+total2+total3+"");
            }
        });

        txt_cant3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                float aux1 = Float.parseFloat(txt_precio1.getText().charAt(0) +""+ txt_precio1.getText().charAt(1));
                int aux2 = Integer.parseInt(txt_precio1.getText().charAt(3) +""+ txt_precio1.getText().charAt(4));
                float aux3 = 0;
                aux3 = (float) (aux2 * 0.01);
                float cant = 0;
                cant = Float.parseFloat(txt_cant1.getText());

                float total = 0;
                total = cant*(aux1+aux3);


                float aux4 = Float.parseFloat(txt_precio2.getText().charAt(0) +""+ txt_precio2.getText().charAt(1));
                int aux5 = Integer.parseInt(txt_precio2.getText().charAt(3) +""+ txt_precio2.getText().charAt(4));
                float aux6 = 0;
                aux6 = (float) (aux5 * 0.01);
                float cant2 = 0;
                cant = Float.parseFloat(txt_cant2.getText());

                float total2 = 0;
                total2 = cant*(aux4+aux6);


                float aux7 = Float.parseFloat(txt_precio3.getText().charAt(0) +""+ txt_precio3.getText().charAt(1));
                int aux8 = Integer.parseInt(txt_precio3.getText().charAt(3) +""+ txt_precio3.getText().charAt(4));
                float aux9 = 0;
                aux6 = (float) (aux8 * 0.01);
                float cant3 = 0;
                cant = Float.parseFloat(txt_cant3.getText());

                float total3 = 0;
                total3 = cant*(aux7+aux9);

                txt_importe1.setText(total+"");
                txt_importe2.setText(total2+"");
                txt_importe3.setText(total3+"");

                txt_importetotal.setText(total+total2+total3+"");
            }
        });
    }

    public static void main(String[] args) {
        int k = 0;
        String csvFile = "productos.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        JFrame frame = new JFrame("parse CSV");
        frame.setContentPane(new parseCSV().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] linea = line.split(cvsSplitBy);
                // Chequo por consola de la lectura del fichero...
                // String[] producto = new String[] {linea[0], linea[1], linea[2], linea[3], linea[4]};
                //System.out.println(Arrays.toString(producto));
                idProducto[k] = Integer.parseInt(linea[0]);
                nombre[k] = linea[1];
                categoria[k] = linea[2];
                presentacion[k] = linea[3];
                precio[k] = linea[4];
                k++;

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
