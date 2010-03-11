/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import com.sun.jmx.remote.util.OrderClassLoaders;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JPanel;
import model.BlokMethodeCoder;
import model.CodewordCoder;
import model.ICoder;
import model.MorseCoder;
import model.NoCoder;
import model.RaamschriftCoder;
import model.SwitchLettersCoder;
import model.WindroosCoder;
import view.CodewordOptionsPanel;
import view.NoOptionsPanel;

/**
 *
 * @author Bram Gadeyne
 */
public class CoderFactory {
    private HashMap<String, Integer> coders;
    private HashMap<String, Font> fonts;
    private static CoderFactory factory;
    public static final String LETTERVOLGORDE="lettervolgorde";
    public static final String MORSE="morse";
    public static final String CODEWOORD="codewoord";
    public static final String WINDROOS="windroosmethode";
    public static final String NOCODER="nocoder";
    public static final String BLOKMETHODE="blokmethode";
    public static final String RAAMSCHRIFT="raamschrift";


    private CoderFactory()
    {
        coders=new HashMap<String, Integer>();
        initCoders();
        initFonts();
    }

    private void initFonts()
    {
        fonts=new HashMap<String, Font>();
        
    }

    public Font getFont(String name)
    {
        if(fonts.containsKey(name))
        {
            return fonts.get(name);
        }else{
            return fonts.get("standard");
        }
    }

    public ArrayList<String> getCodernames()
    {
        ArrayList<String> list=new ArrayList<String>();
        list.addAll(coders.keySet());
        Collections.sort(list);
        return list;
    }

    public static CoderFactory getInstance()
    {
        if(factory==null)
        {
            factory = new CoderFactory();
        }
        return factory;
    }

    private void initCoders()
    {
        coders.put(LETTERVOLGORDE, 1);
        coders.put(MORSE,2);
        coders.put(CODEWOORD, 3);
        coders.put(WINDROOS,4);
        coders.put(BLOKMETHODE,5);
        coders.put(RAAMSCHRIFT,6);
    }

    public ICoder getCoder(String name) throws Exception
    {
        ICoder ic=null;
        int coderval=0;
        if(coders.containsKey(name))
            coderval=coders.get(name);
        switch (coderval)
        {
            case 1: ic=new SwitchLettersCoder(); break;
            case 2: ic=new MorseCoder(); break;
            case 3: ic=new CodewordCoder(); break;
            case 4: ic=new WindroosCoder();break;
            case 5: ic=new BlokMethodeCoder();break;
            case 6: ic=new RaamschriftCoder(); break;
            default: ic=new NoCoder(); break;
        }
        return ic;
    }

    public JPanel getOptionsPanelByName(String name)
    {
        JPanel panel=null;
        if(name.compareTo(CODEWOORD)==0)
            panel=new CodewordOptionsPanel();
        if(panel==null)
            panel=new NoOptionsPanel();
        return panel;
    }
}
