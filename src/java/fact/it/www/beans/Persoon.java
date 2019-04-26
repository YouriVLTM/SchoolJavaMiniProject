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
public class Persoon {
    private String voornaam;
    private String familienaam;
    private int geboortejaar;

    public Persoon() {
    }

    public Persoon(String voornaam, String familienaam) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.geboortejaar = 2000;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public int getGeboortejaar() {
        return geboortejaar;
    }

    public void setGeboortejaar(int geboortejaar) {
        this.geboortejaar = geboortejaar;
    }
    
    
    public String getVolledigeNaam(){
        return this.getVoornaam() + " " + this.getFamilienaam();
    }
    
    
    public String toString(){
        return getFamilienaam().toUpperCase() + " " + getVoornaam().toLowerCase();
    }
}
