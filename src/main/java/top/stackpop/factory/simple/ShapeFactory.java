package top.stackpop.factory.simple;

public class ShapeFactory {
    /**
     * 新增产品需要修改工厂类，违反开闭原则
     * 工厂类违反单一职责
     * @param shapeType
     * @return
     */
    public static Shape getShape(String shapeType){
        if (shapeType == null || shapeType.isEmpty()) return null;

        if (shapeType.equals("circle")){
            return new Circle();
        }else if(shapeType.equals("rectangle")){
            return new Rectangle();
        }else if(shapeType.equals("square")){
            return new Square();
        }else{
            throw new IllegalArgumentException("unsupport type"+shapeType);
        }
    }
}
