package by.it.lyakhova.jd03_02.bean;

public class Transport {

    private long id;
    private String type;

    public Transport(){}

    public Transport(long id, String type){
        this.id = id;
        this.type = type;
    }

    public long getId() { return id; }

    public String getType() { return type; }

    public void setId(long id) { this.id = id; }

    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "transport{" +
                "id = " + id +
                ", type = " + type;
    }
}
