import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private User user;

    // Components
    private JFrame frame;
    private JTextArea textArea;
    private JButton calculateButton;

    public GUI(User user) {
        this.user = user;

        // Initialize frame
        frame = new JFrame("Energy Consumption Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Initialize text area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Initialize button
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalKilowatts = user.calculateTotalKilowatts();
                double totalCost = totalKilowatts * user.getElectricityRate();
                textArea.append("Total energy consumption: " + totalKilowatts + " kWh\n");
                textArea.append("Total cost: $" + totalCost + "\n");
            }
        });
        frame.add(calculateButton, BorderLayout.SOUTH);
    }

    public void display() {
        frame.setVisible(true);
    }
}
