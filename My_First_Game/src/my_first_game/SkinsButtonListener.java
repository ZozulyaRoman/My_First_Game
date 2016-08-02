package my_first_game;

import com.jtattoo.plaf.AbstractLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SkinsButtonListener implements ActionListener {

    private JFrame frame;

    public SkinsButtonListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)) {
            return;
        }
        JButton btn = (JButton) e.getSource();
        String s = btn.getActionCommand();
        AbstractLookAndFeel lnf = null;
        if (s.equals("Skin 1")) {
            lnf = new AluminiumLookAndFeel();
        }
        if (s.equals("Skin 2")) {
            lnf = new SmartLookAndFeel();
        }
        if (s.equals("Skin 3")) {
            lnf = new HiFiLookAndFeel();
        }

        try {
            UIManager.setLookAndFeel(lnf);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SkinsButtonListener.class.getName()).log(Level.SEVERE, null, ex);
        }

        SwingUtilities.updateComponentTreeUI(frame);
    }

}
