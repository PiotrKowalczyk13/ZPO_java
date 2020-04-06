public class Book implements Publication
{
    private String author;
    private String title;
    private Integer pagesCount;

    public Book(String author, String title, Integer pagesCount)
    {
        this.author = author;
        this.title = title;
        this.pagesCount = pagesCount;
    }

    @Override
    public String toString()
    {
        return "| "+getAuthor()+" | "+ getTitle()+"\t| "+getPagesCount()+" |";
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Integer getPagesCount() {
        return pagesCount;
    }
}