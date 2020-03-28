import music.Music;
import java.util.ArrayList;

public class Disc {

    private ArrayList<Music> musicCompositions = new ArrayList<Music>();
    public void addMusic(Music music) {
        musicCompositions.add(music);
    }

    public int getDuration()
    {
        int duration = 0;
        for (int i = 0; i < musicCompositions.size(); i++)
        {
            duration += musicCompositions.get(i).getDuration();
        }
        return duration;
    }

    public void getMusicDuration()
    {
        for (int i = 0; i < musicCompositions.size(); i++ )
        {
            System.out.printf("\n %s", musicCompositions.get(i).toString());
        }
    }
}
