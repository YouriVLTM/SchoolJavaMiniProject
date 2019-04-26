/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www.beans;

import java.time.Year;

/**
 *
 * @author yourivanlaer
 */
public class Relatie {
    private Persoon persoon1;
    private Persoon persoon2;

    public Relatie(Persoon persoon1, Persoon persoon2) {
        this.persoon1 = persoon1;
        this.persoon2 = persoon2;
    }

    public Persoon getPersoon1() {
        return persoon1;
    }

    public void setPersoon1(Persoon persoon1) {
        this.persoon1 = persoon1;
    }

    public Persoon getPersoon2() {
        return persoon2;
    }

    public void setPersoon2(Persoon persoon2) {
        this.persoon2 = persoon2;
    }
    
    public String getScoreLeeftijd(){
        String text = "";
        int leeftijd1 = Year.now().getValue() - this.persoon1.getGeboortejaar();
        int leeftijd2 = Year.now().getValue() - this.persoon2.getGeboortejaar();
        int verschil = (leeftijd1) - (leeftijd2);
        
        if( verschil > 0){
            if( (leeftijd1/2)+7 < leeftijd2 ){
                text = this.persoon1.getVoornaam() + " " + this.persoon2.getVoornaam() + " zij voor elkaar gemaakt";
            }else{
                text = this.persoon1.getVoornaam() + " " + this.persoon2.getVoornaam() + " blijven best gewoon vrienden";
            }
        }else{
            if( (leeftijd2/2)+7 < leeftijd1 ){
                text = this.persoon2.getVoornaam() + " " + this.persoon1.getVoornaam() + " zij voor elkaar gemaakt";
            }else{
                text = this.persoon2.getVoornaam() + " " + this.persoon1.getVoornaam() + " blijven best gewoon vrienden";
            }
        }
        
        return text;
    }
    
    public int getScoreNaam(){
        int score=0;
        if(this.persoon1.getVolledigeNaam().length() > this.persoon2.getVolledigeNaam().length()){
            score = this.persoon2.getVolledigeNaam().length() * 100/this.persoon1.getVolledigeNaam().length();
        }else{
            score = this.persoon1.getVolledigeNaam().length() * 100/this.persoon2.getVolledigeNaam().length();
        }
        
        return score;
    }

}
