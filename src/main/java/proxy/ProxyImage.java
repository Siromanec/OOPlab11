package proxy;

public class ProxyImage implements MyImage{
    private final String filename;
    private RealImage image;
    public  ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(filename);
        }
        image.display();
    }
}

