package clean.architecture.srp.ex.book;

class XmlBookRender implements BookRenderer {
    
    public String render(final Book book) {
        return
            "<book>" +
                "<title>" + book.getTitle() + "</title>" +
                "<authorName>" + book.getAuthorName() + "</authorName>" +
                "<publishDate>" + book.getDateString("yyyy-MM-dd HH:mm:ss.SSSZ") +  "</publishedDate>" +
                "<isbn>" + book.getIsbn() + "</isbn>" +
            "</book>";
    }
}
