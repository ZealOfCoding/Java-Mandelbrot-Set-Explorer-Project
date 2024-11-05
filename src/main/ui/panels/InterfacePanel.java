package ui.panels;

import javax.swing.JPanel;

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
        add(mip);
        add(mp);
        add(lsp);
        add(cp);
    }
    
}
