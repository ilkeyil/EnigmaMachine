import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI extends JFrame {
    private JTextField userInput;
    private JButton encryptButton;
    private JButton resetButton;
    private JTextArea outputArea;
    public static Machine m = new Machine(Main.r1_left, Main.r2_middle, Main.r3_right, Main.refB);

    public GUI() {
        setLayout(new FlowLayout());
        setSize(800, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an array with rotor names for the JComboBoxes
        String[] rotorNames = { "Rotor I", "Rotor II", "Rotor III", "Rotor IV"}; // "Rotor V"
        String[] reflectorNames = {"Reflector B", "Reflector C"};

        // Create panel
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        // Create JComboBoxes for rotor selection
        JComboBox<String> leftRotorBox = new JComboBox<>(rotorNames);
        JComboBox<String> middleRotorBox = new JComboBox<>(rotorNames);
        JComboBox<String> rightRotorBox = new JComboBox<>(rotorNames);
        JComboBox<String> reflectorBox = new JComboBox<>(reflectorNames);

        Character[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        JComboBox<Character> leftStart = new JComboBox<Character>(alphabet);
        JComboBox<Character> middleStart = new JComboBox<Character>(alphabet);
        JComboBox<Character> rightStart = new JComboBox<Character>(alphabet);

        // Add JComboBoxes to panel
        panel.add(new JLabel("  Left Rotor: "));
        panel.add(leftRotorBox);
        leftRotorBox.setSelectedIndex(0);
        panel.add(leftStart);

        panel.add(new JLabel("  Middle Rotor: "));
        panel.add(middleRotorBox);
        middleRotorBox.setSelectedIndex(1);
        panel.add(middleStart);

        panel.add(new JLabel("  Right Rotor: "));
        panel.add(rightRotorBox);
        rightRotorBox.setSelectedIndex(2);
        panel.add(rightStart);

        panel.add(new Label("  Reflector: "));
        panel.add(reflectorBox);
        reflectorBox.setSelectedIndex(0);

        userInput = new JTextField(20);
        encryptButton = new JButton("Encrypt");
        resetButton = new JButton("Reset Rotors");
        outputArea = new JTextArea(5, 30);

        add(userInput);
        add(encryptButton);
        add(outputArea);
        add(resetButton);

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = userInput.getText();
                Translate translate = new Translate(inputText);
                int[] machineLanguage = translate.translateToMachine();
                int[] machineOutput = new int[machineLanguage.length];
                for (int i = 0; i < machineLanguage.length; i++) {
                    machineOutput[i] = m.encryptOneLetter(machineLanguage[i]);
                }
                String humanLanguage = translate.translateToHuman(machineOutput);
                outputArea.setText(humanLanguage);
            }
        });

        resetButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                m.right.reset();
                m.middle.reset();
                m.left.reset();

                leftRotorBox.setSelectedIndex(0);
                middleRotorBox.setSelectedIndex(1);
                rightRotorBox.setSelectedIndex(2);

                rightStart.setSelectedIndex(0);
                middleStart.setSelectedIndex(0);
                leftStart.setSelectedIndex(0);
            }
        });

        leftRotorBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int userChoice = leftRotorBox.getSelectedIndex();
                Rotor selectedRotor = null;
                for (int i = 0; i < Main.allRotorsLeft.length; i++){
                    if(Main.allRotorsLeft[i].id == userChoice){
                        selectedRotor = Main.allRotorsLeft[i];
                        break;
                    }
                }
                m = m.updateMachine(selectedRotor, m.middle, m.right, m.ref);
            }
        });

        middleRotorBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int userChoice = middleRotorBox.getSelectedIndex();
                Rotor selectedRotor = null;
                for (int i = 0; i < Main.allRotorsMiddle.length; i++){
                    if(Main.allRotorsMiddle[i].id == userChoice){
                        selectedRotor = Main.allRotorsMiddle[i];
                        break;
                    }
                }
                m = m.updateMachine(m.left, selectedRotor, m.right, m.ref);
            }
        });

        rightRotorBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int userChoice = rightRotorBox.getSelectedIndex();
                Rotor selectedRotor = null;
                for (int i = 0; i < Main.allRotorsRight.length; i++){
                    if(Main.allRotorsRight[i].id == userChoice){
                        selectedRotor = Main.allRotorsRight[i];
                        break;
                    }
                }
                m = m.updateMachine(m.left, m.middle, selectedRotor, m.ref);
            }
        });

        leftStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userChoice = leftStart.getSelectedIndex();
                m.setStartPosition(userChoice, m.left);
            }
        });

        middleStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userChoice = middleStart.getSelectedIndex();
                m.setStartPosition(userChoice, m.middle);
            }
        });

        rightStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userChoice = rightStart.getSelectedIndex();
                m.setStartPosition(userChoice, m.right);
            }
        });

        reflectorBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userChoice = reflectorBox.getSelectedIndex();
                Rotor selectedRotor = null;
                for (int i = 0; i < Main.allPossibleReflectors.length; i++){
                    if(Main.allPossibleReflectors[i].id == userChoice){
                        selectedRotor = Main.allPossibleReflectors[i];
                    }
                }
                m = m.updateMachine(m.left, m.middle, m.right, selectedRotor);
            }
        });

    }
}