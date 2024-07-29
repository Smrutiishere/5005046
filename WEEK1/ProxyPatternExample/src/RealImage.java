public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image: " + filename);
        // Simulate loading image from a remote server
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}
