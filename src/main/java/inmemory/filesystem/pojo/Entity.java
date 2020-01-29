package inmemory.filesystem.pojo;

public abstract class Entity {
    private String name;
    private String path;
    private Integer size;

    public Entity(String _name, String _path) {
        this.name= _name;
        this.path = _path;
    }

    abstract void setSize();
}
