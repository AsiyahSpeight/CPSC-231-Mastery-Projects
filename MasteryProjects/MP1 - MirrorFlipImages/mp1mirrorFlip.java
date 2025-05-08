public class mp1mirrorFlip {
    // This method will take a 2D char array as input and display it (print it onto the console). 
    // You will use this method to show the original image and the flipped images later on. 
    // You should be careful that each row is printed on a new line, but each column remains on 
    // the same line.

    private static void displayImage(char[][] photo) {
        // Kevin Orpeza assisted in how to start the method along with chatgpt, to clean up the syntax
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                System.out.print(photo[i][j] + "      "); // "+ " and "     ", was a suggestion made by professor during office hours for a more appealing look
            }
            System.out.println(); // Switch lines after each row to maintain the correct 2D layout <- chatgpt assisted in this.
        }
        System.out.println(); // Additional print statement for visual appeal
    }

    /*
     * private static char[][] horizontalMirror(char[][] photo):
     * This method will perform the horizontal flip of the photo and
     * return the modified 2D array. Must work for any sized array.
     */
    private static char[][] horizontalMirror(char[][] photo) {
        int rows = photo.length;
        int cols = photo[0].length; // Ensure that all rows in the array have the same length
        char[][] photoThatIFlipped = new char[rows][cols];

        // For loop to flip each horizontal row and copy it
        // "photoThatIFlipped[i][j] = photo[i][cols - j - 1];" used chatgpt to fill in the blanks
        // Calculates the column index in photo that corresponds to the mirrored position of column j in photoThatIFlipped.
        // Explanation taken from chatgpt, after asking it to fix my code and explain the change. Only fixed relevant code, no irrelevant code was added.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                photoThatIFlipped[i][j] = photo[i][cols - j - 1]; // Mirrors each element in the row
            }
        }
        return photoThatIFlipped;
    }

    /*
     * private static char[][] verticalMirror(char[][] photo):
     * This method will perform the vertical flip of the photo and return the modified 2D array.
     * This method must work for any size array.
     */
    private static char[][] verticalMirror(char[][] photo) {
        int rows = photo.length;
        int cols = photo[0].length;
        char[][] photoThatIFlipped = new char[rows][cols];

        // For loop to flip each vertical row and copy it
        // "photoThatIFlipped[i][j] = photo[rows - i - 1][j]" - used a similar structure from the horizontalMirror method
        // Only changed the row index to perform the vertical mirroring.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                photoThatIFlipped[i][j] = photo[rows - i - 1][j]; // Mirrors each row
            }
        }
        return photoThatIFlipped;
    }

    // MAIN METHOD TO BE EXECUTED
    public static void main(String[] args) {
        /*
        Creating a 2D array with the same dimensions as stated in our input "photo",
        reading every row "i" and column "j" of the input "photo".
        This array represents the image that will be mirrored.
        */ 
        char[][] photo = {
            {'+', 'X', '+', '+', '+'},
            {'+', '@', '@', '@', '+'},
            {'+', '@', 'E', '@', '+'},
            {'*', '@', '@', '|', '@'},
            {'+', '@', '@', '@', '+'},
            {'+', '@', '@', '@', '+'},
            {'+', '+', '+', 'y', '+'},
        };

        // PRINT ORIGINAL
        System.out.println("Display the original image:");
        displayImage(photo);

        // HORIZONTAL FLIP OF IMAGE, DISPLAY OUTPUT
        char[][] photoFlippedHorizontal = horizontalMirror(photo);
        System.out.println("The mirrored photo flipped horizontally:");
        displayImage(photoFlippedHorizontal);

        // VERTICAL FLIP ON THE HORIZONTAL FLIPED IMAGE, DISPLAY PUTPUT
        char[][] flippedImageFull = verticalMirror(photoFlippedHorizontal);
        System.out.println("The mirrored photo flipped both vertically and horizontally:");
        displayImage(flippedImageFull);
    }
}