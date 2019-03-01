
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author capacita_mecon
 */
public class Palabra {
    
    private String _palabra;
    private List _palabras=new ArrayList();
    
    public Palabra()
    {
        
    }
    
    public Palabra(String palabra)
    {
        this._palabra= palabra;
    }
    
    private List _palabras=new ArrayList();	
	public DVD(){}
	public List getMovies() {
		return _palabras;
	}
	public void setMovies(List _palabras) {
		this._palabras = _palabras;
	}	
	public String toString(){
		String _palabras="";
		for(Object movie:getMovies()){
                    Movie m;
                    m=(Movie) movie;
			_palabras += m.getName()+"\n";
		}
		return _palabras; 
	}
    
}
