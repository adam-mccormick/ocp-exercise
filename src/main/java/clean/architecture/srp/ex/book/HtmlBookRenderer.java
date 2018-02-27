package clean.architecture.srp.ex.book;

class HtmlBookRenderer implements BookRenderer{
    
    public String render(final Book book) {
        return
            "<div>" +
                "<label for=\"title\">Title:</label>" +
                "<input id=\"title\" value=\"" + book.getTitle() + "/>" +
                "<label for=\"author\">Author:</label>" +
                "<input id=\"author\" value=\"" + book.getAuthorName() + "/>" +
                "<label for=\"publishDate\">Published Date:</label>" +
                "<input id=\"publishDate\" value=\"" + book.getDateString("yyyy-MM-dd") + "/>" +
                "<label for=\"isbn\">ISBN:</label>" +
                "<input id=\"isbn\" value=\"" + book.getIsbn() + "/>" +
                "</div>";
    }
}
