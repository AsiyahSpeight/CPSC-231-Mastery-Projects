public class ThreadsAccount implements SocialMediaAccount {
    private String username;
    private String email;
    private String password;
    public String bio; // bio is accessible from anywhere
    private int numFollowers;
    private ThreadsPost[] posts; // an array of strings, each string in the array is a post by the user
    private int nextPostIndex;

    // default constructor -- no params, sets everything to default values  
    public ThreadsAccount(){
        username = "unknown";
        email = "unknown";
        password = "unknown";
        bio = "";

        nextPostIndex = 0; // initialized at 0 because the first post should go at index 0 of the posts array 

        numFollowers = 0; // every user starts with 0 followers 
        // we need to initialize the array for posts here! 
        posts = new ThreadsPost[100]; // each user can have 100 posts
    }
    
    public ThreadsAccount(String un, String e, String pw, String b){ // parameters of a constructor are the info/ values the class needs in order to create an instance/ object
        username = un;
        email = e;
        password = pw;
        bio = b;

        nextPostIndex = 0; // initialized at 0 because the first post should go at index 0 of the posts array 

        numFollowers = 0; // every user starts with 0 followers 
        // we need to initialize the array for posts here! 
        posts = new ThreadsPost[100]; // each user can have 100 posts 

    }

    public ThreadsAccount(String un, String e, String pw){ // parameters of a constructor are the info/ values the class needs in order to create an instance/ object
        username = un;
        email = e;
        password = pw;

        bio = ""; // Since no bio was given, we set the bio to an empty string 

        nextPostIndex = 0; // initialized at 0 because the first post should go at index 0 of the posts array 

        numFollowers = 0; // every user starts with 0 followers 
        // we need to initialize the array for posts here! 
        posts = new ThreadsPost[100]; // each user can have 100 posts 
    }

    public ThreadsAccount(ThreadsAccount accountToCopy){
        username = accountToCopy.username;
        email = accountToCopy.email;
        password = accountToCopy.password;

        bio = accountToCopy.bio; 
        nextPostIndex = accountToCopy.nextPostIndex; 

        numFollowers = accountToCopy.numFollowers;  
     
        posts = accountToCopy.posts; 
    }

    public String getUsername(){ 
        return username;
    }
    public String getEmail(){ 
        return email;
    }
    public String getBio(){ 
        return bio;
    }
    public int getNumFollowers(){
        return numFollowers;
    }
    public ThreadsPost[] getPosts(){
        return posts;
    }
    public ThreadsPost getPost(int i){
        if (i < nextPostIndex){
            return posts[i];
        } else {
            return null;
        }
    }

    public void setUsername(String un){
        username = un;
    }

    public void setPassword(String pw){
        if (pw.length() < 8){
            System.out.println("New password is too short.");
            return; // do not change pw and exit method
        }
        password = pw;
    }


    public void gainFollower(){ // gain one follower at a time
        ++numFollowers;
        System.out.println("Follower gained! Total number of followers: " + numFollowers);
    }

    public void makePost(String post){
        // save post to our posts array 
        // option 1: iterate through array until we find an empty spot where we can place the post
                        // kinda slow and unnecessary work  
        // option 2: we will hold a variable that keeps track of the next available index in the array 
        // we need to make sure that we still have space in the array, only add post if there is space
        if (nextPostIndex < posts.length){ // then index is within range 
            System.out.println("New Post by " + username + ":\n" + post);
            posts[nextPostIndex] = new ThreadsPost(post); 
            ++nextPostIndex; // increment so that the next post is to the right of the current post in the array 
        } else {
            System.out.println("Error: could not post! too many posts made.");
        }  
    }


    public String toString(){
        String s = "";
        // I will add into s all of the information I want displayed when printing a ThreadsAccount object
        s += "Welcome to @" + username + "'s account!\n";
        s += "Followers: " + numFollowers + "\n";
        s += "Posts: \n";
        
        for (int i = nextPostIndex-1; i >= 0; --i){
            s += "\t*" + posts[i] + "\n";
        }
        return s;
    }

    public boolean equals(Object o){ // o is ta2, Object is any object, providing flexibility 
        if (this == o){ // checking whether o and the object the method was called upon share the same memory address
            // if they share the same address then they are the same obj so they are equal
            return true;
        }
        // if Object o is not a ThreadsAccount type object then we for sure know they are not equal
        if (! (o instanceof ThreadsAccount)){ 
            // o is not of type ThreadsAccount 
            return false;
        }
        // if we have reached this point then we know that o is a ThreadsAccount object 
        // type cast o into a ThreadsAccount type to compare member variables
        ThreadsAccount ta = (ThreadsAccount) o; 
        // now we are able to check the values of member varaiables 
        // we check whatever makes sense for our application 
        return this.username.equals(ta.username); // 'this' is ta1
    }


}