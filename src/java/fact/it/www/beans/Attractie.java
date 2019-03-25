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
public class Attractie {
    private String naam;
    private long duur;
    private String foto;
    
    private Personeelslid verantwoordelijke;

    public Attractie() {
    }

    public Attractie(String naam) {
        this.naam = naam;
    }

    public Attractie(String naam, long duur) {
        this.naam = naam;
        this.duur = duur;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public long getDuur() {
        return duur;
    }

    public void setDuur(long duur) {
        this.duur = duur;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public Personeelslid getVerantwoordelijke(){
        return verantwoordelijke;
    }
    
    public void setVerantwoordelijke(Personeelslid verantwoordelijke){
        this.verantwoordelijke = verantwoordelijke;
    }
    
}
