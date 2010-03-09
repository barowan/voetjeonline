/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.HashMap;

/**
 *
 * @author Bram Gadeyne
 */
public class MorseCoder extends ICoder {

    HashMap<Character, String> morsemap;

    public MorseCoder()
    {
        morsemap=new HashMap<Character, String>();
        initMorseMap();
    }

    private void initMorseMap()
    {
        morsemap.clear();
        morsemap.put('a',".-");
        morsemap.put('b',"-...");
        morsemap.put('c',"-.-.");
        morsemap.put('d',"-..");
        morsemap.put('e',".");
        morsemap.put('f',"..-.");
        morsemap.put('g',"--.");
        morsemap.put('h',"....");
        morsemap.put('i',"..");
        morsemap.put('j',".---");
        morsemap.put('k',"-.-");
        morsemap.put('l',".-..");
        morsemap.put('m',"--");
        morsemap.put('n',"-.");
        morsemap.put('o',"---");
        morsemap.put('p',".--.");
        morsemap.put('q',"--.-");
        morsemap.put('r',".-.");
        morsemap.put('s',"...");
        morsemap.put('t',"-");
        morsemap.put('u',"..-");
        morsemap.put('v',"...-");
        morsemap.put('w',".--");
        morsemap.put('x',"-..-");
        morsemap.put('y',"-.--");
        morsemap.put('z',"--..");
        morsemap.put('0',"-----");
        morsemap.put('1',".----");
        morsemap.put('2',"..---");
        morsemap.put('3',"...--");
        morsemap.put('4',"....-");
        morsemap.put('5',".....");
        morsemap.put('6',"-....");
        morsemap.put('7',"--...");
        morsemap.put('8',"---..");
        morsemap.put('9',"----.");
    }

    public String code(String s) {
        char[] arr=s.toLowerCase().toCharArray();
        String coded="";
        for(int i=0;i<arr.length;i++)
        {
            if(morsemap.containsKey(arr[i]))
            {
                coded+=morsemap.get(arr[i])+"/";
            }else{
                coded+=arr[i]+"/";
            }
        }
        return coded;
    }

    public String decode(String d) {
        throw new UnsupportedOperationException("morse decoderen komt in een latere versie..");
    }
}
