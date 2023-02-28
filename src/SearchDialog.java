import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class SearchDialog extends JDialog implements ActionListener {
    protected EmployeeDetails parent;
    protected JButton search, cancel;
    protected JTextField searchField;
    protected String label;
    protected String title;

    public SearchDialog(EmployeeDetails parent) {
        super(parent,true);
        this.parent = parent;
        setModal(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane(searchPane());
        setContentPane(scrollPane);
        getRootPane().setDefaultButton(search);
        setSize(500, 190);
        setLocation(350, 250);
        setVisible(true);
    }

    public Container searchPane(){
        JPanel searchPanel = new JPanel(new GridLayout(3, 1));
        JPanel textPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel searchLabel;

        searchPanel.add(new JLabel("Search by " + getLabel()));

        textPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        textPanel.add(searchLabel = new JLabel("Enter " + getLabel() +":"));
        searchLabel.setFont(this.parent.font1);
        textPanel.add(searchField = new JTextField(20));
        searchField.setFont(this.parent.font1);
        searchField.setDocument(new JTextFieldLimit(20));

        buttonPanel.add(search = new JButton("Search"));
        search.addActionListener(this);
        search.requestFocus();

        buttonPanel.add(cancel = new JButton("Cancel"));
        cancel.addActionListener(this);

        searchPanel.add(textPanel);
        searchPanel.add(buttonPanel);

        return searchPanel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            searchAction();
        } else if (e.getSource() == cancel) {
            dispose();
        }
    }

    protected abstract void searchAction();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
}
