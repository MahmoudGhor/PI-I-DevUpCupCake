/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.idevup.cupcake.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 *
 * @author mahmo
 */
public class ReadRSS {
    
    public static String readRss(String urlAddress) {
        try{
        URL rssUrl = new URL(urlAddress);
        BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
        String sourceCode="";
        String line;
        while ((line = in.readLine())!=null) {
        if (line.contains("<title>"))
        {
            int firstPos = line.indexOf("<title");
            String temp = line.substring(firstPos);
            temp=temp.replace("<title>", "");
            int lastPos = temp.indexOf("</title>");
            temp = temp.substring(0,lastPos);
            sourceCode += temp+"\n";
            
        }
        }
        in.close();
        return sourceCode;
        
        
    }
        catch (MalformedURLException ue)
        {
            System.out.println("malformed");
        }
        catch (IOException ex)
        {
            System.out.println("io exception");
        }
        return null;
    }
    
    
}
