public class ProductDB {
    public static GenericQueue<Product> getProducts(String code) {
        GenericQueue<Product> products = new GenericQueue<Product>();

        if (code.equalsIgnoreCase("b")) {
            // Create five ball instances and add them to balls queue
            for (int i = 1; i <= 5; i++) {
                Ball ball = new Ball();
                ball.setCode("B" + i);
                ball.setDescription("Ball " + i);
                ball.setPrice(99.99 + i);
                ball.setColor("Color " + i);
                products.enqueue(ball);
            }
        } else if (code.equalsIgnoreCase("s")) {
            // Create five shoe instances and add them to shoes queue
            for (int i = 1; i <= 5; i++) {
                Shoe shoe = new Shoe();
                shoe.setCode("S" + i);
                shoe.setDescription("Shoe " + i);
                shoe.setPrice(49.99 + i);
                shoe.setSize(9.0 + i);
                products.enqueue(shoe);
            }
        } else if (code.equalsIgnoreCase("a")) {
            // Create three bag instances and add them to bags queue
            for (int i = 1; i <= 3; i++) {
                Bag bag = new Bag();
                bag.setCode("A" + i);
                bag.setDescription("Bag " + i);
                bag.setPrice(89.99 + i);
                bag.setType("Type " + i);
                products.enqueue(bag);
            }
        }

        return products;
    }
}
