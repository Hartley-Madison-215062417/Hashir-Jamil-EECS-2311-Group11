package tab2mxl;

public class Musically {
	
	
    public static char checkLineStep (int line) {

        char step;
        if(line == 1)
            step = 'E';
        else if (line == 2)
            step = 'A';
        else if (line == 3)
            step = 'D';
        else if (line == 4)
            step = 'G';
        else if (line == 5)
            step = 'B';
        else 
            step = 'E';

        return step;

    }

    public static int checkLineOctave (int line) {

        int octave;
        if(line == 1)
            octave = 2;
        else if (line == 2)
            octave = 2;
        else if (line == 3)
            octave = 3;
        else if (line == 4)
            octave = 3;
        else if (line == 5)
            octave = 3;
        else 
            octave = 4;

        return octave;
    }

    public static boolean isGuitar (String name) {

        boolean isGuitar = false;
        if(name == "Classical Guitar")
            isGuitar = true;

        return isGuitar;
    }



}
