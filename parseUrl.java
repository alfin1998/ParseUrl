/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas;

/**
 *
 * @author Alfin
 */
import java.net.MalformedURLException;
import java.net.URL;
 
public class parseUrl {
    
    
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://example.com:80/docs/books/tutorial/index.html?name=networking#DOWNLOADING");
 
        System.out.println("protocol: " + url.getProtocol());
        System.out.println("authority: " + url.getAuthority());
        System.out.println("host: " + url.getHost());
        System.out.println("port: " + url.getPort());
        System.out.println("path:" + url.getPath());
        System.out.println("query: " + url.getQuery());
        System.out.println("filename: " + url.getFile());
        System.out.println("ref: " + url.getRef());
    }
}
