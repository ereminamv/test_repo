import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class TestFrame extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private String filename = "Number_base.txt";


    public TestFrame() {
        super("Test frame");
        createGUI();
    }


    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Add");
        button1.setActionCommand("Button 1 was pressed!");
        panel.add(button1);


        JButton button3 = new JButton("Save");
        button3.setActionCommand("Button 3 was pressed!");
        panel.add(button3);

        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField1.setColumns(23);
        textField2.setColumns(23);
        textField3.setColumns(23);
        panel.add(textField1);
        panel.add(textField2);
        panel.add(textField3);

        Object rowData[][] = { { "89506085263", "Ivanov", "45" },
                { "89104567896", "Petrov", "100" } };
        Object columnNames[] = { "Number", "Holder", "Balance" };
        JTable table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.AFTER_LAST_LINE);
        panel.setVisible(true);

        ActionListener actionListener = new TestActionListener();

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String number = textField1.getText();
                String holder = textField2.getText();
                Integer balance = new Integer(textField3.getText());
                new TestFrame().update(number + " " + holder + " " + balance + "\n");

            }
        });


        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField2.setText(e.getActionCommand());
            }
        });

        getContentPane().add(panel);
        setPreferredSize(new Dimension(500, 500));
    }

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textField1.setText(e.getActionCommand());
            textField2.setText(e.getActionCommand());
            textField3.setText(e.getActionCommand());
        }
    }
    public void create(String filename) throws IOException {
        File file = new File(filename);
        try {
            //���������, ��� ���� ���� �� ���������� �� ������� ���
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
        file.exists();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String s;
            try {
                while ((s = in.readLine()) != null) {
                    if(s.length()!= 0){
                        sb.append(s);
                        sb.append("\n");
                        System.out.println("S: " + s.length());
                    }
                }

                in.close();
            } catch (IOException ex) {

            }

        } catch (FileNotFoundException ex) {

        }
        return sb.toString();
    }

    public static void write(String fileName, String text) {
        //���������� ����
        File file = new File(fileName);

        try {
            //PrintWriter ��������� ����������� ������ � ����
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //���������� ����� � ����
                out.println(text);
            } finally {
                //����� ���� �� ������ ������� ����
                //����� ���� �� ���������
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String newText) {
        File file = new File(new TestFrame().filename);
        file.exists();
        StringBuilder sb = new StringBuilder();
        String oldFile = read(new TestFrame().filename);

        sb.append(oldFile);
        // write(EmployeeUI.filename, sb.toString());
        sb.append(newText);

        write(new TestFrame().filename, sb.toString());
        System.out.println(file.length());
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                TestFrame frame = new TestFrame();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                try {
                    frame.create(frame.filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}