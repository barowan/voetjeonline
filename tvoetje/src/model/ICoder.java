/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import control.FontFactory.Fonts;
import java.util.HashMap;

/**
 *
 * @author Bram Gadeyne
 */
public abstract class ICoder {
    public String code(String s)
    {
        return "Not yet supported";
    }
    public String decode(String d){
        return "Not yet supported";
    }

    public void setOptions(HashMap<String,String> options){
    }

    public Fonts getFont()
    {
        return Fonts.DEFAULT;
    }
}
