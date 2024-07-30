package proxy.patter;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Adding image from disk: " + filename);
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Image Added: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Show image: " + filename);
    }
}