package model.entity;

/**
 * Created by ivoni on 1/12/2017.
 */
public class Attribute implements Entity{

    int id;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
