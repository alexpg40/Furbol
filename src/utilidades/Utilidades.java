/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import furbol.Equipo;
import furbol.Jugador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Alex Perez
 */
public class Utilidades {

    public static void leerFichero(String ubicacion) {
        String texto;
        File f = new File(ubicacion);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    System.out.println(texto);
                }
                br.close();
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    public static void escribirFichero(String ubicacion) {
        String linea;
        BufferedWriter bw = null;
        BufferedReader br = null;
        File f = new File(ubicacion);
        try {
            FileWriter fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            System.out.println("Escribe para saltar de linea pulsa enter y para salir pulsa enter en una linea vacia para salir");
            do {
                linea = br.readLine();
                if (!linea.isEmpty()) {
                    bw.write(linea);
                    bw.newLine();
                }
            } while (!linea.isEmpty());
        } catch (IOException e) {
            System.out.println("Error");
        } finally {
            try {
                bw.close();
                br.close();
            } catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }

    public static void vaciarFichero(String ubicacion) {
        BufferedWriter bw = null;
        File f = new File(ubicacion);
        try {
            FileWriter fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            bw.write("");
        } catch (IOException e) {
            System.out.println("Error");
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }

    public static <T> void leerArrayList(ArrayList<T> array) {
        for (T t : array) {
            System.out.println(t);
        }
    }

    public static <T> ArrayList<T> arraytoArrayList(T[] array) {
        ArrayList<T> ret = new ArrayList<>();
        for (T t : array) {
            ret.add(t);
        }
        return ret;
    }

    public static <T> ArrayList<T> leerObjetos(String direccion) {
        ArrayList<T> ret = new ArrayList<>();
        InputStream is;
        ObjectInput in = null;
        try {
            is = new FileInputStream(direccion);
            in = new ObjectInputStream(is);
            while (is.available() > 0) {
                T t = (T) in.readObject();
                System.out.println(t);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Se ha dado una IOException");
        } catch (ClassNotFoundException ex) {
            System.out.println("Fallo al convertir el objeto a jugador");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el Stream");
                }
            }
        }
        return ret;
    }

    public static <T> void guardarObjetos(ArrayList<T> array, String direccion) {
        OutputStream os;
        ObjectOutput ob;
        try {
            os = new FileOutputStream(direccion);
            ob = new ObjectOutputStream(os);
            for (T t : array) {
                ob.writeObject(t);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Se ha dado una IOException");
        }
    }

    public static final Equipo EQUIPOS[] = {
        new Equipo(1, "Atletico de Madrid", 20, 5, 10, 3, 2),
        new Equipo(2, "Getafe", 12, 1, 8, 5, 2),
        new Equipo(3, "Valencia", 12, 1, 8, 5, 2),
        new Equipo(4, "Racing de Santander", 17, 9, 9, 4, 2),
        new Equipo(5, "Oviedo", 6, 20, 1, 5, 9),
        new Equipo(6, "Sporting de Gijón", 2, 14, 0, 7, 8)
    };

    public static final Jugador JUGADORES[] = {
        new Jugador("Joao", "Felix", 1)
    };

    public static String readXML(String TagName) {
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        String ret = "";
        File xml = new File("ConexionBD.xml");
        try {
            dBuilder = dFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            System.out.println("Se ha dado un error al intentar Parsear el documento xml");
        }
        Document doc = null;
        try {
            doc = dBuilder.parse(xml);
            doc.normalize();
        } catch (SAXException ex) {
            System.out.println("Se ha producido una SAXException");
        } catch (IOException ex) {
            System.out.println("Se ha producido una IOException");
        }

        NodeList nlist = doc.getElementsByTagName(TagName);
        ret = nlist.item(0).getTextContent();
        return ret;
    }

}
