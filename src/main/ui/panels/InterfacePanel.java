package ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class InterfacePanel extends JPanel {
    private ManualInputsPanel mip;
    private MessagesPanel mp;
    private LoadSavePanel lsp;
    private ConfigurationsPanel cp;

    /* EFFECTS:
     * Constructs an InterfacePanel containing:
     * - ManualInputsPanel
     * - MessagesPanel
     * - LoadSavePanel
     * - ConfigurationsPanel
     */
    public InterfacePanel() {
        //super(new GridLayout(4, 1, 0, 0));
        super();
        mip = new ManualInputsPanel();
        mp = new MessagesPanel();
        lsp = new LoadSavePanel();
        cp = new ConfigurationsPanel();

        
        add(mip, BorderLayout.CENTER);
        add(mp, BorderLayout.CENTER);
        add(lsp, BorderLayout.CENTER);
        add(cp, BorderLayout.CENTER);

        setDefaults();
    }

    private void setDefaults() {
        setPreferredSize(new Dimension(400, 800));
        setBackground(Color.BLUE);
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

}
