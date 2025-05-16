package stringcompressee;

import java.text.StringCharacterIterator;

public class CompressString_demo {
    public String compressedString;

    public CompressString_demo(String string){
        this.compressedString = compress(string);
    }

    public int originalSize(){
        String decompressed_string = decompress();
        int size = decompressed_string.length();

        // byte sized string
        return size * 16 ;
    }

    public String decompress() {
        String returnValue = "";

        String[] temp = this.compressedString.split(", ");

        // [8x a], [2x b], [7x c]

        for (int i = 0; i < temp.length; i++) {
            String[] temp2 = temp[i].split("x ");

            // [8] [a]

            int count = Integer.parseInt(temp2[0]);



            for (int j = 0; j < count; j++) {
                returnValue += temp2[1];
            }
        }

        return returnValue;
    }

    private String compress(String original){
        if ( original == null || original.equals("") ) {
            return "";
        }

        String finalString = "";


        // aaaaaaaaab_b_cccccccccc

        // 8x a, 2x b, 7x c

        char previous = original.charAt(0);
        char current;
        int count = 1;
        for (int i = 1; i < original.length(); i++) {
            current = original.charAt(i);

            if (current == previous) {
                count++;
            } else {
                finalString += count + "x " + previous + ", ";
                previous = current;
                count = 1;
            }

            previous = current;
        }

        finalString += count + "x " + previous;


        return finalString;
    }
}
