/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fact.it.www.beans;

import java.util.ArrayList;

/**
 *
 * @author yourivanlaer
 */
public class Pretpark {
    private String naam;
    private int aantalBezoekers;
    private ArrayList<Attractie> attracties = new ArrayList<>();

    public Pretpark(String name) {
        this.naam = name;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
    
    public ArrayList<Attractie> getAttracties(){
        return this.attracties;
    }
    
    public void voegAttractieToe(Attractie attractie){
        this.attracties.add(attractie);
    }
    
    public int getAantalAttracties(){
        return this.attracties.size();
    }
    
    public Attractie zoekAttractieOpNaam(String naam){
        for(Attractie attractie : attracties){
            if(attractie.getNaam().equals(naam)){
                return attractie;
            }
        }        
        return null;
    }
    
    public void registreerBezoeker(Bezoeker bezoeker){
        this.aantalBezoekers+=1;
        bezoeker.setPretparkcode(this.aantalBezoekers);
    }
    
    public int pretparkMatch(Bezoeker bezoeker){        
        int counter=0;       
        for(String attractie : bezoeker.getWishlist()){
            if(this.zoekAttractieOpNaam(attractie) !=null){
                counter++;
            }
        } 
        return (int)((counter*1.00/(bezoeker.getAantalOpWishlist()))*100);    
    }
    
}
    
    
    
