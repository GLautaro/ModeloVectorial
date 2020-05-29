/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author agu_9
 */
public class ParserPalabra {

    public static String limpiarPalabra(String token) {
        String palabraLimpia = limpiarVocales(token);
        palabraLimpia = palabraLimpia.toLowerCase();

        return palabraLimpia;
    }

    private static String limpiarVocales(String token) {
        String original = "áàäéèëíìïóòöúùüç";
        String modificacion = "aaaeeeiiiooouuuc";

        for (int z = 0; z < original.length(); z++) {
            token = token.replace(original.charAt(z), modificacion.charAt(z));
        }

        return token;
    }
}
