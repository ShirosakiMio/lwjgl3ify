package me.eigenraven.lwjgl3ify.relauncher;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressDialog {

    public JProgressBar progressBar;
    public JButton cancelButton;
    public JLabel statusLabel;
    public JPanel panel;
    public JLabel filesLabel;

    public void loadTranslations() {
        final ResourceBundle bundle = ResourceBundle.getBundle("me.eigenraven.lwjgl3ify.relauncher.TranslationsBundle");
        statusLabel.setText(bundle.getString(TranslationsBundle.KEY_PROGRESS_DOWNLOADING_HEADER));
        cancelButton.setText(bundle.getString(TranslationsBundle.KEY_CANCEL));
    }

    {
        // GUI initializer generated by IntelliJ IDEA GUI Designer
        // >>> IMPORTANT!! <<<
        // DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer >>> IMPORTANT!! <<< DO NOT edit this method OR call it in your
     * code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        progressBar = new JProgressBar();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 16, 0, 16);
        panel.add(progressBar, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(spacer1, gbc);
        cancelButton = new JButton();
        cancelButton.setText("KEY_CANCEL");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 16, 16);
        panel.add(cancelButton, gbc);
        statusLabel = new JLabel();
        statusLabel.setText("KEY_PROGRESS_DOWNLOADING_HEADER");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 16, 8, 0);
        panel.add(statusLabel, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(spacer3, gbc);
        filesLabel = new JLabel();
        filesLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 16, 0, 16);
        panel.add(filesLabel, gbc);
    }

    /** @noinspection ALL */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

}
