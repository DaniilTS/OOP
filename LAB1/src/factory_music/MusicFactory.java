package factory_music;
import music.*;

public class MusicFactory {
    public static Music createMusic(TypeMusic typeMusic,int dur){
        switch (typeMusic){
            case OBJ_HARD_ROCK:
                return new HardRock(dur,true,typeMusic.getName());
            case OBJ_LIGHT_ROCK:
                return  new LightRock(dur,false,typeMusic.getName());
            case OBJ_NATIONAL_FOLK:
                return new NationalFolk(dur,true,typeMusic.getName());
            case OBJ_POP_FOLK:
                return new PopFolk(dur,false,typeMusic.getName());
            default: return null;
        }
    }
}
