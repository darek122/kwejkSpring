package pl.dareksk.data;

import org.springframework.stereotype.Component;
import pl.dareksk.models.Gif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {

    private  static List<Gif> ALLGifs= Arrays.asList(

            new Gif("android-explosion","michalos",true,1),
            new Gif("ben-and-mike","ben",true,2),
            new Gif("book-dominos","dom",true,3),
            new Gif("compiler-bot","bot",true,1),

            new Gif("cowboy-coder","coder",true,2),
            new Gif("infinite-andrew","andrw",true,3)

    );
    public Gif findByName(String name){
        for(Gif gif:ALLGifs){
            if(gif.getName().equals(name)){
                return gif;
            }
        }
        return null;
    }

    public List<Gif> getAllGifs(){
        return ALLGifs;
    }

    public List<Gif> getFavorites(){
        List<Gif> gifs=new ArrayList<>();
        for(Gif gif:ALLGifs){
            if(gif.isFavorite()){
                gifs.add(gif);
            }
        }
        return gifs;
    }
    public List<Gif> getById(int id){
        List<Gif> gifs=new ArrayList<>();
        for(Gif gif:ALLGifs){
            if(gif.getCategoryId()==id){
                gifs.add(gif);
            }
        }
        return gifs;
    }

}
