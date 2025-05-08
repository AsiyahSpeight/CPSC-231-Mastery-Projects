public class ThreadsPost implements SocialMediaAccount{
    // Attributes
    private String text;     // The content of the post
    private int likes;       // Number of likes for the post

    // Constructor
    public ThreadsPost(String text) {
        // Validate the text length (280 characters max)
        if (text.length() <= 280) {
            this.text = text;
        } else {
            this.text = "";  // Initialize with an empty string if the post is too long
            System.out.println("Post exceeds character limit!");
        }
        this.likes = 0;       // Initialize with 0 likes
    }

    // Accessor methods (getters)
    public String getText() {
        return text;
    }

    public int getLikes() {
        return likes;
    }

    // Mutator methods (setters)
    public void setText(String text) {
        if (text.length() <= 280) {
            this.text = text;
        } else {
            System.out.println("Post exceeds character limit!");
        }
    }

    public void likePost() {
        this.likes++;
    }

    // Display method
    public void displayPost() {
        System.out.print("Post: " + text);
        System.out.println(" || Likes: " + likes);
    }

    // toString method to return the post in string format
    
    public String toString() {
        String s = "";
        s += "Post: " + text;
        s += " || Likes: " + likes + "\n";
        return s;
    }

    // Equals method to compare two posts
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;   // same exact object 
        if (obj == null || !(obj instanceof ThreadsPost)) return false;     // obj is either null or not a ThreadsPost
        ThreadsPost post = (ThreadsPost) obj;   // cast obj back to ThreadsPost so that you can access member variables  
        return likes == post.likes && text.equals(post.text);   // compare member variables 
    }
}