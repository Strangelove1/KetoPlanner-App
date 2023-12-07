package pl.strangelove;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"description"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    public static class BookBuilder {
        private Long id;
        private String title;
        private String description;

        BookBuilder() {
        }

        public BookBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Book build() {
            return new Book(this.id, this.title, this.description);
        }

        public String toString() {
            return "Book.BookBuilder(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ")";
        }
    }
}
