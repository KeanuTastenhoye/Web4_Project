package domain;

public class Message {
    private String writer;
    private String bericht;

    public Message(String writer, String bericht) {
        this.writer = writer;
        this.bericht = bericht;
    }

    //Getters

    public String getWriter() { return writer; }

    public String getBericht() { return bericht; }

    //Setters

    public void setWriter(String writer) { this.writer = writer; }

    public void setBericht(String bericht) { this.bericht = bericht; }

    @Override
    public String toString() {
        return "Message{" +
                "writer='" + writer + '\'' +
                ", bericht='" + bericht + '\'' +
                '}';
    }
}
