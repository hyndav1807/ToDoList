import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoList extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInputField;
    private JButton addButton;
    private JButton deleteButton;

    public ToDoList() {
        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top panel for input and add button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        taskInputField = new JTextField();
        inputPanel.add(taskInputField, BorderLayout.CENTER);

        addButton = new JButton("Add");
        inputPanel.add(addButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.NORTH);

        // Center area for task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Bottom panel for delete button
        deleteButton = new JButton("Delete");
        add(deleteButton, BorderLayout.SOUTH);

        // Add button action
        addButton.addActionListener(e -> addTask());

        // Delete button action
        deleteButton.addActionListener(e -> deleteTask());

        setVisible(true);
    }

    private void addTask() {
        String task = taskInputField.getText().trim();
        if (!task.isEmpty()) {
            taskListModel.addElement(task);
            taskInputField.setText("");
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoList::new);
    }
}