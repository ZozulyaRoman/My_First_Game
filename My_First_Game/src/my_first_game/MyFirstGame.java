package my_first_game;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Роман
 */
public class MyFirstGame {

    private JFrame frame;

    private JPanel panelLeft;
    private JPanel panelRight;
    private JPanel panelButton;
    private JPanel panelSkins;

    protected static JLabel label;

    private JTextField textfield;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    private JButton skinButton1;
    private JButton skinButton2;
    private JButton skinButton3;

    private static int randomNum;

    protected static final String[] LABLES = {"/pic/0.jpg", "/pic/1.jpg", "/pic/2.jpg", "/pic/3.jpg", "/pic/4.jpg", "/pic/5.jpg", "/pic/6.jpg", "/pic/7.jpg",};

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new HiFiLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MyFirstGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);

        MyFirstGame game = new MyFirstGame();
        game.creatFrame();
        game.creatTextField();
        game.creatPanels();
        game.creatButtons();

        game.addButtonsToPanel();

        game.addPanelsToFrame();

        randomNum = Logic.random();

        game.addButtonListeners();

        game.frame.setVisible(true);
    }

    private void creatFrame() {
        frame = new JFrame("game");
        frame.setIconImage(new ImageIcon(getClass().getResource("/pic/package_games_board_8101.png")).getImage());
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(500, 430));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    private void creatPanels() {
        label = new JLabel(new ImageIcon(getClass().getResource(Logic.labelPic(LABLES))));
        panelLeft = new JPanel();
        panelLeft.setMinimumSize(new Dimension(200, 380));
        panelLeft.setBorder(BorderFactory.createEtchedBorder());
        panelLeft.add(label);

        panelRight = new JPanel();
        BoxLayout bl = new BoxLayout(panelRight, BoxLayout.Y_AXIS);
        panelRight.setLayout(bl);
        panelRight.setPreferredSize(new Dimension(300, 400));
        panelRight.setBorder(BorderFactory.createEtchedBorder());

        panelButton = new JPanel(new GridLayout(3, 3, 2, 2));
        panelButton.setPreferredSize(new Dimension(200, 300));
        panelButton.setBorder(BorderFactory.createEtchedBorder());

        panelSkins = new JPanel(new FlowLayout());
        panelSkins.setPreferredSize(new Dimension(500, 30));
        panelSkins.setBorder(BorderFactory.createEtchedBorder());
    }

    private void creatTextField() {
        textfield = new JTextField("Я загадала число от 1 до 9, попробуй отгадай");
        textfield.setPreferredSize(new Dimension(100, 100));
        textfield.setEditable(false);
        textfield.setFocusable(false);

    }

    private void creatButtons() {
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        skinButton1 = new JButton("Skin 1");
        skinButton2 = new JButton("Skin 2");
        skinButton3 = new JButton("Skin 3");
    }

    private void addPanelsToFrame() {
        panelRight.add(textfield);
        panelRight.add(panelButton);
        frame.add(panelLeft, BorderLayout.CENTER);
        frame.add(panelRight, BorderLayout.EAST);
        frame.add(panelSkins, BorderLayout.NORTH);
    }

    private void addButtonsToPanel() {
        panelButton.add(button1);
        panelButton.add(button2);
        panelButton.add(button3);
        panelButton.add(button4);
        panelButton.add(button5);
        panelButton.add(button6);
        panelButton.add(button7);
        panelButton.add(button8);
        panelButton.add(button9);

        panelSkins.add(skinButton1);
        panelSkins.add(skinButton2);
        panelSkins.add(skinButton3);

    }

    private void addButtonListeners() {
        ButtonsListener bl = new ButtonsListener(randomNum, panelRight);

        button1.addActionListener(bl);
        button2.addActionListener(bl);
        button3.addActionListener(bl);
        button4.addActionListener(bl);
        button5.addActionListener(bl);
        button6.addActionListener(bl);
        button7.addActionListener(bl);
        button8.addActionListener(bl);
        button9.addActionListener(bl);

        SkinsButtonListener sl = new SkinsButtonListener(frame);

        skinButton1.addActionListener(sl);
        skinButton2.addActionListener(sl);
        skinButton3.addActionListener(sl);
    }

}
