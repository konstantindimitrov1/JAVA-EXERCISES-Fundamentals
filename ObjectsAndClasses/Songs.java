import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int songsCount = Integer.parseInt(scanner.nextLine());
        List<Song> allSongs = new ArrayList<>();

        for (int i = 0; i < songsCount; i++) {
            String[] data = scanner.nextLine().split("_");
            Song song = new Song();
            song.setName(data[1]);
            song.setTypeList(data[0]);
            allSongs.add(song);
        }

        String input = scanner.nextLine();

        if (input.equals("all")) {
            for (Song allSong : allSongs) {
                System.out.println(allSong.getName());
            }
        } else {
            for (Song allSong : allSongs) {
                if (allSong.getTypeList().equals(input)) {
                    System.out.println(allSong.getName());
                }
            }
        }
    }
}

class Song {
    private String typeList;
    private String name;

    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
