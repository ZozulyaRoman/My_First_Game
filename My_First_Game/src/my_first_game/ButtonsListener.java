package my_first_game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonsListener implements ActionListener {

    private int randomNum;
    private static int count;
    private JPanel panel;
    private static int winCount;

    public static int getWinCount() {
        return winCount;
    }

    public static void setWinCount(int winCount) {
        ButtonsListener.winCount = winCount;
    }

    public ButtonsListener() {
    }

    public ButtonsListener(int randomNum, JPanel panel) {
        this.randomNum = randomNum;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)) {
            return;
        }
        JButton btn = (JButton) e.getSource();
        count++;
        String messText = Logic.compareInt(Integer.parseInt(btn.getActionCommand()), count, randomNum);
        JOptionPane.showMessageDialog(panel, messText);
        MyFirstGame.label.setIcon(new ImageIcon(getClass().getResource(Logic.labelPic(MyFirstGame.LABLES))));
        if (Integer.parseInt(btn.getActionCommand()) == randomNum) {
            count = 0;
            randomNum = Logic.random();

        }

    }

}
