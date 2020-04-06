public class BookWrapper implements Publication
{
    private Publication publication;
    public BookWrapper(Publication pubinst) throws CoverException
    {
        if(!(pubinst instanceof BookRegularCover) && !(pubinst instanceof BookHardCover))
            throw new CoverException("Książka bez okładki nie może mieć obwoluty!");
        this.publication = pubinst;
    }

    @Override
    public String toString()
    {
        return this.publication.toString()+" Z Obwolutą |";
    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public Integer getPagesCount() {
        return null;
    }
}