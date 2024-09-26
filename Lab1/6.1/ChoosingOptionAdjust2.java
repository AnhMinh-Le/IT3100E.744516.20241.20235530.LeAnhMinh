import javax.swing.JOptionPane;
public class ChoosingOptionAdjust2 {
    public static void main(String[] args) {
        String[] options = {"I do", "I don't"};  
        int option = JOptionPane.showOptionDialog(
                null, 
                "Do you want to change to the first class ticket?", 
                "Ticket Upgrade", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]);
        JOptionPane.showMessageDialog(null, "You've chosen: " 
                + (option == 0 ? "I do" : "I don't"));
        System.exit(0);
    }
}