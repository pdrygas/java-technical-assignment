package kata.supermarket;

abstract class Product implements Categorisable {
    private final Category category;

    protected Product(Category category) {
        this.category = category;
    }

    @Override
    public Category getCategory() {
        return category;
    }
}
