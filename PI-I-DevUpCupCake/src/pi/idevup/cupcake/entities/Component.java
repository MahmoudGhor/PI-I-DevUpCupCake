package pi.idevup.cupcake.entities;

/**
 *
 * @author Dorra
 */
public class Component {
    private int componentId;
    private String componentname;
    private int quantity;

    public Component(int componentId, String componentname, int quantity) {
        this.componentId = componentId;
        this.componentname = componentname;
        this.quantity = quantity;
    }

    public Component(String componentname, int quantity) {
        this.componentname = componentname;
        this.quantity = quantity;
    }

    public Component() {
    }

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public String getComponentname() {
        return componentname;
    }

    public void setComponentname(String componentname) {
        this.componentname = componentname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Component{componentname=" + componentname + ", quantity=" + quantity + '}';
    }   
}