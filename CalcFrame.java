import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class CalcFrame extends JFrame{
    
    public CalcFrame(){
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new CalcPanel());
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
    }
}
