/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www.beans;

/**
 *
 * @author yourivanlaer
 */
public class Personeelslid extends Persoon {

    public Personeelslid(String voornaam,String familienaam) {
        super(voornaam,familienaam);
    }
    
    @Override
    public String toString(){
        return "Personeelslid " + super.toString();
    }
}
