import factory_music.*;
import music.*;

public class BuildDisc {

    public static Disc createDisc(int duration1, int duration2, int duration3, int duration4)
    {
        Disc disc = new Disc();

        HardRock hardRock = (HardRock) MusicFactory.createMusic(TypeMusic.OBJ_HARD_ROCK,duration1);
        LightRock lightRock = (LightRock) MusicFactory.createMusic(TypeMusic.OBJ_LIGHT_ROCK,duration2);
        NationalFolk nationalFolk = (NationalFolk) MusicFactory.createMusic(TypeMusic.OBJ_NATIONAL_FOLK,duration3);
        PopFolk popFolk = (PopFolk) MusicFactory.createMusic(TypeMusic.OBJ_POP_FOLK,duration4);

        disc.addMusic(hardRock);
        disc.addMusic(lightRock);
        disc.addMusic(nationalFolk);
        disc.addMusic(popFolk);

        return disc;
    }

    public static void main(String[] args) {

        System.out.print("Disc 1:");
        Disc disc1 = createDisc(100,120,400,320);
        disc1.getMusicDuration();
        System.out.printf("\n Full Duration:%s",disc1.getDuration());

        System.out.print("\n\nDisc 2:");
        Disc disc2 = createDisc(180,120,112,456);
        disc2.getMusicDuration();
        System.out.printf("\n Full Duration:%s",disc2.getDuration());
    }
}
