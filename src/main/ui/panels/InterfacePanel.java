package ui.panels;

import ui.PanelsEventMediator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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
        super();

        initializeElements();
        setDefaults();
        addElements();
    }

    /*
     * EFFECTS: establishes the mediator object for inter-class communication. 
     */
    public void setMediator(PanelsEventMediator panelsEventMediator) {
        //this.panelsEventMediator = panelsEventMediator;
        mip.setMediator(panelsEventMediator);
        //mp.setMediator(panelsEventMediator);
        lsp.setMediator(panelsEventMediator);
        cp.setMediator(panelsEventMediator);
    }

    /*
     * EFFECTS: initializes the subpanels. 
     */
    private void initializeElements() {
        mip = new ManualInputsPanel();
        mp = new MessagesPanel();
        lsp = new LoadSavePanel();
        cp = new ConfigurationsPanel();
    }

    /*
     * EFFECTS: sets defaults of this panel.
     */
    private void setDefaults() {
        setPreferredSize(new Dimension(400, 800));
        setBackground(Color.BLUE);
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /*
     * EFFECTS: adds subpanels to this panel.
     */
    private void addElements() {
        add(mip, BorderLayout.CENTER);
        add(mp, BorderLayout.CENTER);
        add(lsp, BorderLayout.CENTER);
        add(cp, BorderLayout.CENTER);
    }

    /*
     * EFEFCTS: returns getManualInputsPanel(). Used to instantiate an instance of 
     *  PanelsEventMediator in GuiMandelbrotSetViewerApp.
     */
    public ManualInputsPanel getManualInputsPanel() {
        return mip;
    }

    /*
     * EFEFCTS: returns getMessagesPanel(). Used to instantiate an instance of 
     *  PanelsEventMediator in GuiMandelbrotSetViewerApp.
     */
    public MessagesPanel getMessagesPanel() {
        return mp;
    }

    /*
     * EFEFCTS: returns getLoadSavePanel(). Used to instantiate an instance of 
     *  PanelsEventMediator in GuiMandelbrotSetViewerApp.
     */
    public LoadSavePanel getLoadSavePanel() {
        return lsp;
    } 

    /*
     * EFEFCTS: returns getConfigurationsPanel(). Used to instantiate an instance of 
     *  PanelsEventMediator in GuiMandelbrotSetViewerApp.
     */
    public ConfigurationsPanel getConfigurationsPanel() {
        return cp;
    }

}
