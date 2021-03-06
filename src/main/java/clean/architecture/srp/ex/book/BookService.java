package clean.architecture.srp.ex.book;

import java.util.Map;

/**
 * This service is the facade over the persistence mechanism and the rendering
 * components for {@link Book} instances. The methods {@code printHtml(Book)},
 * {@code printXml(Book)} and {@link #save(Book)} have been brought out of the
 * {@link Book} class and into this facade.
 * <p>
 * This facade relies on implementations of {@link BookRepository} and {@link BookRenderer}
 * to delegate to. This leaves these smaller components with a smaller interface
 * and a more "singular responsibility".
 * <p>
 * There is a problem though; new requirements mean that we need to add new ways
 * of rendering a {@link Book}. A naive way to accomplish this is to keep adding
 * {@code printXXX} methods and new implementations of {@link BookRenderer} to
 * delegate to.
 * <p>
 * Your goal is to modify the code in a way that allows new ways of rendering a
 * {@link Book} to be added without needing to further modify this class. Once
 * you're done a new way of rendering a {@link Book} should not require a developer
 * to make modifications to this class.
 * <p>
 * Bonus points: also consider ways of allowing modifications to the existing
 * {@link BookRenderer} implementations that would allow extension implementations
 * to enhance or alter the way the base implementations work. For example an HTML
 * rendering for screen vs print. How might you do this? Abstract base classes,
 * more delegates, configurations, builders?.
 */
public class BookService {
    
    private final BookRepository repository;
    private final Map<String, BookRenderer> renders;
    
    public BookService(final BookRepository repository, final Map<String, BookRenderer> renders){
        this.repository = repository;
        this.renders = renders;
    }
    
    public String print(final Book book, final String mime){
        return this.renders.get(mime).render(book);
    }
    
    public Book save(final Book book){
        return this.repository.save(book);
    }
}
