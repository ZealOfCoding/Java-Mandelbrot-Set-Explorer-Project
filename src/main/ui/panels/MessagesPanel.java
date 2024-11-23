package ui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import ui.PanelsEventMediator;
/*//////////////////////////////////////////////////////////////
 * DESIGN RECONSIDERATION:
 * - replace this with just a simple pop up error window?
 * 
 * THINGS TO DO:
 * - make the whole panel have a flash animation when updated.
 */////////////////////////////////////////////////////////////


public class MessagesPanel extends JPanel {
    private JTextArea messagesBox;
    private PanelsEventMediator panelsEventMediator;
    
    /*
     * EFFECTS: Constructor nitializes elements, sets defaults, and adds elements. 
     */
    public MessagesPanel() {
        super();
        initializeElements();
        setDefaults();
        addElements();

    }

    /*
     * EFFECTS: sets the mediator object for inter-class communication. 
     */
    public void setMediator(PanelsEventMediator panelsEventMediator) {
        this.panelsEventMediator = panelsEventMediator;
    }

    /*
     * EFFECTS: initializes the JTextArea for the messages panel.
     */
    private void initializeElements() {
        messagesBox = new JTextArea("System Messages Display Panel");
    }

    /*
     * EFFECTS: sets defaults. 
     */
    private void setDefaults() {
        setBackground(Color.ORANGE);
        setPreferredSize(new Dimension(400, 75));
        messagesBox.setBackground(Color.GRAY);
        messagesBox.setFont(new Font("Verdana", Font.PLAIN, 15));
        messagesBox.setPreferredSize(new Dimension(380, 65));
        messagesBox.setLineWrap(true);
        messagesBox.setEditable(false);
    }

    /*
     * EFFECTS: adds the messages box to the JPanel
     */
    private void addElements() {
        add(messagesBox, BorderLayout.CENTER);
        
    }

    /*
     * EFFECTS: sets the message of the JTextArea
     */
    public void setMessage(String message) {
        messagesBox.setText(message);
    }

    //TODO: use to catch exceptions, and their error messages, and display them to the user.
}
