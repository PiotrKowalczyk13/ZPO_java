public class BookRegularCover implements Publication
{
    private Publication publication;
    public BookRegularCover(Publication pubinst) throws CoverException
    {
        if(pubinst instanceof BookRegularCover || pubinst instanceof BookHardCover)
            throw new CoverException("Książka nie może mieć dwóch okładek!");
        this.publication = pubinst;
    }

    @Override
    public String toString()
    {
        return this.publication.toString()+" Zwykła Oprawa |";
    }

    @Override
    public String getAuthor() {
        return this.publication.getAuthor();
    }

    @Override
    public String getTitle() {
        return this.publication.getTitle();
    }

    @Override
    public Integer getPagesCount() {
        return this.publication.getPagesCount();
    }
}