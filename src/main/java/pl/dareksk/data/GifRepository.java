package pl.dareksk.data;

import org.springframework.stereotype.Component;
import pl.dareksk.models.Gif;
import sun.net.www.content.image.gif;

import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {

    private  static List<Gif> ALLGifs= Arrays.asList(

            new Gif("android-explosion","michalos",true),
            new Gif("ben-and-mike","ben",true),
            new Gif("book-dominos","dom",true),
            new Gif("compiler-bot","bot",true),

            new Gif("cowboy-coder","coder",true),
            new Gif("infinite-andrew","andrw",true)

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
}
