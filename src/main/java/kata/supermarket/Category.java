package kata.supermarket;

import java.util.Objects;

/**
 * Represents a range of products and forms a one-to-many relationship with them.
 */
class Category {
    static final String NO_CATEGORY = "none";

    static Category noCategory() {
        return new Category(NO_CATEGORY);
    }

    private final String name;

    Category(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
