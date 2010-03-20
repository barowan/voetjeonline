/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.AIsXCoder;

/**
 *
 * @author bram
 */
public class AIsXOptionsPanel extends IOptionsPanel{
    JTextField xField;

    public AIsXOptionsPanel() {
        super();
        setXField();
        addControls();
    }

    private void setXField()
    {
        xField=new JTextField();
        xField.setColumns(13);
    }

    private void addControls()
    {
        JLabel label=new JLabel(AIsXCoder.X);
        label.setForeground(Color.WHITE);

        this.add(label);
        
        this.add(xField);
        this.revalidate();
        this.validate();
    }

    @Override
    public HashMap<String, String> getOptionValues() {
        HashMap<String, String> hm=new HashMap<String, String>();
        hm.put(AIsXCoder.X, xField.getText());
        return hm;
    }

    @Override
    public String validateOptions() {
        String error=super.validateOptions();
        //error=error+"test error in AIsXOptionsPanel";
        try
        {
            Integer x=Integer.parseInt(xField.getText());
            if(!(x>=1 && x<=26))
                throw new Exception();
            if(xField.getText().length()==0)
                throw new Exception();
        }catch(NumberFormatException ex){
            error=error+"x is not a number";
        }catch(Exception e){
            error=error+"x moet tussen 1 en 26 liggen";
        }

        return error;
    }

    





}
