/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.CodewordCoder;

/**
 *
 * @author bram
 */
public class CodewordOptionsPanel extends IOptionsPanel {
    
    JTextField codewordField;

    public CodewordOptionsPanel() {
        super();
        codewordField=new JTextField();
        addControls();
    }

    private void addControls()
    {
        JLabel label=new JLabel(CodewordCoder.codeword);
        label.setForeground(Color.WHITE);

        this.add(label);

        codewordField.setColumns(13);
        this.add(codewordField);
        this.revalidate();
        this.validate();
    }

    @Override
    public HashMap<String, String> getOptionValues() {
        HashMap<String, String> hm=new HashMap<String, String>();
        hm.put(CodewordCoder.codeword, codewordField.getText());
        return hm;
    }


}
