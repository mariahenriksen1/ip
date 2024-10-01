import java.util.Scanner;

public class ProfanityFilter {
    public static void main(String[] args) {
    
    //read input with scanner
        Scanner scanner = new Scanner(System.in);
        
        String swearWordLine = scanner.nextLine();
        
        //store Swear words
        String[] swearWordsArray = swearWordLine.split("\\s+"); //store swear woords in an array


        //process text
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] words = line.split(" "); //split by spaces into words

            StringBuilder filteredLine = new StringBuilder();

        //Handle each word
        for (String word : words) {

            String wordWithoutPunctuation = word.replaceAll("[.,!?]", "");
            String punctuation = ""; // Initialize punctuation variable

        // Check if there's punctuation at the end - important otherwise it prints too many ---
            if (word.length() > 0 && !Character.isLetterOrDigit(word.charAt(word.length() - 1))) {
                punctuation = word.substring(word.length() - 1); // Capture the last character if it's punctuation
                wordWithoutPunctuation = wordWithoutPunctuation.trim(); // Trim spaces
            }

            String filteredWord = wordWithoutPunctuation;
        
            //checks if there is a swear word
            for (String swearWord : swearWordsArray) {
                if (wordWithoutPunctuation.equalsIgnoreCase(swearWord)) {
                    filteredWord = generateReplacement(wordWithoutPunctuation.length());
                }
            }
            // Reattach punctuation and add to the filtered line
            filteredLine.append(filteredWord).append(punctuation).append(" ");
    
        }
           System.out.println(filteredLine.toString().trim());

        }
        scanner.close();


        }

            public static String generateReplacement(int length){
                StringBuilder replacement = new StringBuilder();
                String pattern = "*&#$%";
                for(int i = 0; i<length; i++){
                    replacement.append(pattern.charAt(i % pattern.length())); //reapeate the pattern
                }

                return replacement.toString(); //return the final replacement string
            }

}