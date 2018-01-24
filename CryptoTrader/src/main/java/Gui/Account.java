package Gui;

import DataHandling.DataHandler;
import Exceptions.CryptoTraderException;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.webcerebrium.binance.api.BinanceApiException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Account {
    public JPanel Outter;
    private JButton button_Account;
    private JButton button_Main;
    private JButton button_Settings;
    private JPanel content;
    private JPanel content_Home;
    private JTextField field_AccountSettings;
    private JTextField field_Username;
    private JPasswordField field_RepeatPassword;
    private JPasswordField field_Password;
    private JPasswordField field_BinanceKey;
    private JButton button_ok;
    private JPasswordField field_BinanceSecret;

    public Account() {

        //init stuff
        field_Username.setText(GUITest.username);

        button_Main.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set which screens
                GUITest.switchScreens("home");
            }
        });
        button_Settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //set which screens
                GUITest.switchScreens("settings");
            }
        });
        button_ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //check if their are changes and commit them to the account file
                if (field_Password.getText().equals(field_RepeatPassword.getText()) && field_Password.getText().length() > 0) {
                    DataHandler.saveAccountSettings(GUITest.username,
                            field_Password.getText(),
                            DataHandler.openAccountSettings(GUITest.username)[2],
                            DataHandler.openAccountSettings(GUITest.username)[3]);
                } else if (!field_Password.getText().equals(field_RepeatPassword.getText()) && field_Password.getText().length() > 0) {
                    JOptionPane.showMessageDialog(Outter, "Passwords do not match");
                }
                if (field_BinanceKey.getText().length() > 0) {
                    DataHandler.saveAccountSettings(GUITest.username,
                            DataHandler.openAccountSettings(GUITest.username)[1],
                            field_BinanceKey.getText(),
                            DataHandler.openAccountSettings(GUITest.username)[3]);
                }
                if (field_BinanceSecret.getText().length() > 0) {
                    DataHandler.saveAccountSettings(GUITest.username,
                            DataHandler.openAccountSettings(GUITest.username)[1],
                            DataHandler.openAccountSettings(GUITest.username)[2],
                            field_BinanceSecret.getText());
                }
                //clear the fields
                field_Password.setText("");
                field_RepeatPassword.setText("");
                field_BinanceKey.setText("");
                field_BinanceSecret.setText("");
            }
        });
        //This has to be here to initialize the main window
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        Outter = new JPanel();
        Outter.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        Outter.setBackground(new Color(-16747077));
        Outter.setForeground(new Color(-16747077));
        Outter.setMinimumSize(new Dimension(1280, 720));
        Outter.setPreferredSize(new Dimension(1280, 720));
        final Spacer spacer1 = new Spacer();
        Outter.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        button_Account = new JButton();
        button_Account.setBackground(new Color(-16750009));
        Font button_AccountFont = this.$$$getFont$$$("Verdana", Font.PLAIN, 30, button_Account.getFont());
        if (button_AccountFont != null) button_Account.setFont(button_AccountFont);
        button_Account.setForeground(new Color(-16777216));
        button_Account.setText("Account");
        Outter.add(button_Account, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 255), null, 0, false));
        button_Main = new JButton();
        button_Main.setBackground(new Color(-16729220));
        Font button_MainFont = this.$$$getFont$$$("Verdana", Font.PLAIN, 30, button_Main.getFont());
        if (button_MainFont != null) button_Main.setFont(button_MainFont);
        button_Main.setForeground(new Color(-16777216));
        button_Main.setText("Home");
        Outter.add(button_Main, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 225), null, 0, false));
        button_Settings = new JButton();
        button_Settings.setBackground(new Color(-16729220));
        Font button_SettingsFont = this.$$$getFont$$$("Verdana", Font.PLAIN, 30, button_Settings.getFont());
        if (button_SettingsFont != null) button_Settings.setFont(button_SettingsFont);
        button_Settings.setForeground(new Color(-16777216));
        button_Settings.setText("Settings");
        Outter.add(button_Settings, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 225), null, 0, false));
        content = new JPanel();
        content.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        Outter.add(content, new GridConstraints(1, 1, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        content_Home = new JPanel();
        content_Home.setLayout(new GridLayoutManager(14, 2, new Insets(0, 0, 0, 0), -1, -1));
        content_Home.setBackground(new Color(-9079691));
        content_Home.setEnabled(true);
        Font content_HomeFont = this.$$$getFont$$$("Verdana", Font.PLAIN, 26, content_Home.getFont());
        if (content_HomeFont != null) content_Home.setFont(content_HomeFont);
        content_Home.setVisible(true);
        content.add(content_Home, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        content_Home.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(-16777216)), null));
        field_AccountSettings = new JTextField();
        field_AccountSettings.setEditable(false);
        Font field_AccountSettingsFont = this.$$$getFont$$$("Verdana", Font.BOLD, 48, field_AccountSettings.getFont());
        if (field_AccountSettingsFont != null) field_AccountSettings.setFont(field_AccountSettingsFont);
        field_AccountSettings.setText("Account Settings");
        content_Home.add(field_AccountSettings, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        field_RepeatPassword = new JPasswordField();
        Font field_RepeatPasswordFont = this.$$$getFont$$$("Verdana", Font.PLAIN, 26, field_RepeatPassword.getFont());
        if (field_RepeatPasswordFont != null) field_RepeatPassword.setFont(field_RepeatPasswordFont);
        content_Home.add(field_RepeatPassword, new GridConstraints(7, 1, 2, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        field_Password = new JPasswordField();
        Font field_PasswordFont = this.$$$getFont$$$("Verdana", Font.PLAIN, 26, field_Password.getFont());
        if (field_PasswordFont != null) field_Password.setFont(field_PasswordFont);
        content_Home.add(field_Password, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        field_Username = new JTextField();
        field_Username.setEditable(false);
        Font field_UsernameFont = this.$$$getFont$$$("Verdana", Font.PLAIN, 26, field_Username.getFont());
        if (field_UsernameFont != null) field_Username.setFont(field_UsernameFont);
        content_Home.add(field_Username, new GridConstraints(2, 1, 3, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Verdana", Font.PLAIN, 26, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Change Password");
        content_Home.add(label1, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Verdana", Font.PLAIN, 26, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Repeat");
        content_Home.add(label2, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        content_Home.add(spacer2, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        content_Home.add(spacer3, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Verdana", Font.PLAIN, 26, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Username");
        content_Home.add(label3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Verdana", Font.PLAIN, 26, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setText("Change Binance Key");
        content_Home.add(label4, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        field_BinanceKey = new JPasswordField();
        Font field_BinanceKeyFont = this.$$$getFont$$$("Verdana", Font.PLAIN, 26, field_BinanceKey.getFont());
        if (field_BinanceKeyFont != null) field_BinanceKey.setFont(field_BinanceKeyFont);
        content_Home.add(field_BinanceKey, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer4 = new Spacer();
        content_Home.add(spacer4, new GridConstraints(12, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        content_Home.add(spacer5, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        button_ok = new JButton();
        Font button_okFont = this.$$$getFont$$$("Verdana", Font.PLAIN, 26, button_ok.getFont());
        if (button_okFont != null) button_ok.setFont(button_okFont);
        button_ok.setText("OK");
        content_Home.add(button_ok, new GridConstraints(13, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$("Verdana", Font.PLAIN, 26, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setText("Change Binance Secret");
        content_Home.add(label5, new GridConstraints(11, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        field_BinanceSecret = new JPasswordField();
        content_Home.add(field_BinanceSecret, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return Outter;
    }
}
