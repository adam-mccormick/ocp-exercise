package clean.architecture.srp.ex.book;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

class HtmlBookRenderer implements BookRenderer{
    
    private final String template;
    
    public HtmlBookRenderer(final String template){
        this.template = template;
    }
    
    public String render(final Book book) {
        Map<String, Object> context = new HashMap<>();
        context.put("title", book.getTitle());
        context.put("author", book.getAuthorName());
        context.put("published", book.getDateString("yyyy-MM-dd"));
        context.put("isbn", book.getIsbn());
    
        return MessageFormat.format(this.template, context.values().toArray());
        
//        return
//            "<div>" +
//                "<label for=\"title\">Title:</label>" +
//                "<input id=\"title\" value=\"" + book.getTitle() + "/>" +
//                "<label for=\"author\">Author:</label>" +
//                "<input id=\"author\" value=\"" + book.getAuthorName() + "/>" +
//                "<label for=\"publishDate\">Published Date:</label>" +
//                "<input id=\"publishDate\" value=\"" + book.getDateString("yyyy-MM-dd") + "/>" +
//                "<label for=\"isbn\">ISBN:</label>" +
//                "<input id=\"isbn\" value=\"" + book.getIsbn() + "/>" +
//                "</div>";
    }
}
