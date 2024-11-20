package ui.panels;

import model.Renderer;
import ui.PanelsEventMediator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import java.awt.event.*;

import model.ConfigurationList;

public class InterfacePanel extends JPanel {

    private ManualInputsPanel mip;
    private MessagesPanel mp;
    private LoadSavePanel lsp;
    private ConfigurationsPanel cp;

    private PanelsEventMediator panelsEventMediator;

    /* EFFECTS:
     * Constructs an InterfacePanel containing:
     * - ManualInputsPanel
     * - MessagesPanel
     * - LoadSavePanel
     * - ConfigurationsPanel
     */
    public InterfacePanel() {
        super();

        initializeElements();
        setDefaults();
        addElements();
        addKeyListener(null);
    }

    public void setMediator(PanelsEventMediator panelsEventMediator) {
        this.panelsEventMediator = panelsEventMediator;
        mip.setMediator(panelsEventMediator);
        mp.setMediator(panelsEventMediator);
        lsp.setMediator(panelsEventMediator);
        cp.setMediator(panelsEventMediator);

    }

    private void initializeElements() {
        mip = new ManualInputsPanel();
        mp = new MessagesPanel();
        lsp = new LoadSavePanel();
        cp = new ConfigurationsPanel();

    }

    private void setDefaults() {
        setPreferredSize(new Dimension(400, 800));
        setBackground(Color.BLUE);
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void addElements() {
        add(mip, BorderLayout.CENTER);
        add(mp, BorderLayout.CENTER);
        add(lsp, BorderLayout.CENTER);
        add(cp, BorderLayout.CENTER);
    }

    public ManualInputsPanel getManualInputsPanel() {
        return mip;
    }

    public MessagesPanel getMessagesPanel() {
        return mp;
    }

    public LoadSavePanel getLoadSavePanel() {
        return lsp;
    } 

    public ConfigurationsPanel getConfigurationsPanel() {
        return cp;
    }

}
