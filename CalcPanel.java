import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.util.LinkedList;

public class CalcPanel extends JPanel implements ActionListener{
    
    private JTextField jtf;
    private double mem;
    private boolean isSolution;

    public CalcPanel(){
        this.mem = 0;
        isSolution = false;
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        jtf = new JTextField("0", 20);
        jtf.setEditable(false);
        jtf.setHorizontalAlignment(JTextField.RIGHT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        panel1.add(jtf);
        panel2.setLayout(new GridLayout(5,5));
        JButton[] buttons = new JButton[25];
        panel2.add(buttons[0] = new JButton("AC"));
        panel2.add(buttons[1] = new JButton("MR"));
        panel2.add(buttons[2] = new JButton("MC"));
        panel2.add(buttons[3] = new JButton("M+"));
        panel2.add(buttons[4] = new JButton("M-"));

        panel2.add(buttons[5] = new JButton("SQRT"));
        panel2.add(buttons[6] = new JButton("7"));
        panel2.add(buttons[7] = new JButton("8"));
        panel2.add(buttons[8] = new JButton("9"));
        panel2.add(buttons[9] = new JButton("/"));

        panel2.add(buttons[10] = new JButton("X^2"));
        panel2.add(buttons[11] = new JButton("4"));
        panel2.add(buttons[12] = new JButton("5"));
        panel2.add(buttons[13] = new JButton("6"));
        panel2.add(buttons[14] = new JButton("*"));

        panel2.add(buttons[15] = new JButton("X^3"));
        panel2.add(buttons[16] = new JButton("1"));
        panel2.add(buttons[17] = new JButton("2"));
        panel2.add(buttons[18] = new JButton("3"));
        panel2.add(buttons[19] = new JButton("+"));

        panel2.add(buttons[20] = new JButton("+/-"));
        panel2.add(buttons[21] = new JButton("0"));
        panel2.add(buttons[22] = new JButton("."));
        panel2.add(buttons[23] = new JButton("="));
        panel2.add(buttons[24] = new JButton("-"));

        for (int i = 0; i < buttons.length; i++)
            buttons[i].addActionListener(this);
        this.add(panel1);
        this.add(panel2);
        this.setSize(100,150);
    }
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        JButton button = (JButton) obj;
        String s = button.getText();
        String str = jtf.getText();
        String[] strs = null;
        char c = 0, ch = 0;
        ch = s.charAt(0);
        c = str.charAt(str.length() - 1);
        if (s.equals("AC")){
            System.out.println(s);
            str = "0";
            jtf.setText(str);
        }
        else if (s.equals("MR")){
            if (mem % 1 == 0)
                str = String.valueOf((int)mem);
            else
                str = String.valueOf(mem);
            jtf.setText(str);
            isSolution = true;
        }
        else if (s.equals("MC")){
            this.mem = 0;
        }
        else if (s.equals("M+")){
            strs = str.split(" ");
            if (strs.length == 1)
                this.mem += Double.valueOf(jtf.getText());
        }
        else if (s.equals("M-")){
            strs = str.split(" ");
            if (strs.length == 1)
                this.mem -= Double.valueOf(jtf.getText());
        }
        else if (s.equals("+/-")){
            isSolution = true;
            strs = str.split(" ");
            if (strs.length == 1) {
                double d = Double.valueOf(strs[0]);
                if (d % 1 == 0)
                    str = String.valueOf(-1 * Integer.valueOf(strs[0]));
                else
                    str = String.valueOf(-1 * Double.valueOf(strs[0]));
            }
            else if (strs.length == 2) {
                double d = Double.valueOf(strs[0]);
                if (d % 1 == 0)
                    str = String.valueOf(-1 * Integer.valueOf(strs[0]) +
                            " " + strs[1]);
                else
                    str = String.valueOf(-1 * Double.valueOf(strs[0]) + 
                            " " + strs[1]);
                isSolution = false;
            }
            else {
                strs[2] = String.valueOf(-1 * Double.valueOf(strs[2]));
                str = null;
                for (int i = 0; i < strs.length; i++) {
                    if (i == 0)
                        str = strs[i];
                    else
                        str += (" " + strs[i]);
                }
                isSolution = false;
            }
            jtf.setText(str);
        }
        else if (s.equals("SQRT")){
            strs = str.split(" ");
            if (strs.length == 1) {
                double num = Math.sqrt(Double.valueOf(str));
                if (num % 1 == 0)
                    str = String.valueOf((int)num);
                else
                    str = String.valueOf(num);
                jtf.setText(str);
                isSolution = true;
            }
        }
        else if (s.equals("X^2")){
            strs = str.split(" ");
            if (strs.length == 1) {
                double num = Math.pow(Double.valueOf(str),2);
                if (num % 1 == 0)
                    str = String.valueOf((int)num);
                else
                    str = String.valueOf(num);
                jtf.setText(str);
                isSolution = true;
            }
        }
        else if (s.equals("X^3")){
            strs = str.split(" ");
            if (strs.length == 1) {
                double num = Math.pow(Double.valueOf(str),3);
                if (num % 1 == 0)
                    str = String.valueOf((int)num);
                else
                    str = String.valueOf(num);
                jtf.setText(str);
                isSolution = true;
            }
        }
        else if (ch >= 48 && ch <= 57) {
            strs = str.split(" ");
            if (str.equals("0") || isSolution) {
                jtf.setText(String.valueOf(ch));
            }
            else {
                if (str.length() ==  1 || c == '.' || (strs.length == 3 && Double.valueOf(strs[2]) > 0) || c >= 48 && c <= 57)
                    jtf.setText(str += String.valueOf(ch));
                else if (strs.length == 3 && Math.abs(Double.valueOf(strs[0])) == Math.abs(Double.valueOf(strs[2]))
                      && (Double.valueOf(strs[0]) < 0 || Double.valueOf(strs[2]) < 0)) {
                    str = (strs[0] + " " + strs[1] + " -" + ch);
                    System.out.println(str);
                    jtf.setText(str);
                }
                else
                    jtf.setText(str += (" " + ch));
            }
            isSolution = false;
        }
        else if (s.equals("/")) {
            isSolution = false;
            strs = str.split(" ");
            if (strs.length < 3 && str.length() != 0 && c != '/' && c != '*' && c != '+' && c != '-')
                jtf.setText(str += (" " + ch));
            else
                jtf.setText(solve(strs) + " " + ch);
        }
        else if (s.equals("*")) {
            isSolution = false;
            strs = str.split(" ");
            if (strs.length < 3 && str.length() != 0 && c != '/' && c != '*' && c != '+' && c != '-')
                jtf.setText(str += (" " + ch));
            else
                jtf.setText(solve(strs) + " " + ch);
        }
        else if (s.equals("+")) {
            isSolution = false;
            strs = str.split(" ");
            if (strs.length < 3 && str.length() != 0 && c != '/' && c != '*' && c != '+' && c != '-')
                jtf.setText(str += (" " + ch));
            else
                jtf.setText(solve(strs) + " " + ch);
        }
        else if (s.equals("-")) {
            isSolution = false;
            strs = str.split(" ");
            if (strs.length < 3 && str.length() != 0 && c != '/' && c != '*' && c != '+' && c != '-')
                jtf.setText(str += (" " + ch));
            else
                jtf.setText(solve(strs) + " " + ch);
        }
        else if (s.equals(".")) {
            strs = str.split(" ");
            s = strs[strs.length - 1];
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*"))
                jtf.setText(str += (" 0" + String.valueOf(ch)));
            else if (!s.contains(String.valueOf(ch)))
                jtf.setText(str += String.valueOf(ch));
        }
        else { // if (ch == '=')
            strs = str.split(" ");
            jtf.setText(solve(strs));
            isSolution = true;
        }
    }
    public static String solve(String[] strs) {
        String result = null;
        LinkedList<Double> nums = new LinkedList<Double>();
        LinkedList<Character> chs = new LinkedList<Character>();
        for (int i = 0; i < strs.length; i++){
            if (i % 2 == 0) {
                nums.add(new Double(strs[i]));
            }
            else {
                chs.add(new Character(strs[i].charAt(0)));
            }
        }
        while (!chs.isEmpty()){
            int i = 0;
            if (chs.get(0) == '/'){
                nums.set(i, nums.get(i) / nums.get(i + 1));
                nums.remove(i + 1);
            }
            else if (chs.get(0) == '*'){
                nums.set(i, nums.get(i) * nums.get(i + 1));
                nums.remove(i + 1);
            }
            else if (chs.get(0) == '+'){
                nums.set(i, nums.get(i) + nums.get(i + 1));
                nums.remove(i + 1);
            }
            else {
                nums.set(i, nums.get(i) - nums.get(i + 1));
                nums.remove(i + 1);
            }
            chs.remove();
            i++;
        }
        //for (int i = 0; i < nums.size(); i++){
          //  System.out.println(nums.get(i));
        //}
        //for (int i = 0; i < chs.size(); i++){
        //    System.out.println(chs.get(i));
        //}
        result = String.valueOf(nums.get(0));
        if (nums.get(0) % 1 == 0) {
            result = String.valueOf(nums.remove().intValue());
        }
        return result;
    }
}
