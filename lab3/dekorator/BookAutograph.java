public class BookAutograph implements Publication
{
    private String autograph;
    private Publication publication;
    public BookAutograph(Publication pubinst, String autograph) throws CoverException
    {
        if(pubinst instanceof BookAutograph) {
            throw new CoverException("Książka nie może mieć dwóch autografów!");
        }
        else{

        }
        this.publication = pubinst;
        this.autograph = autograph;
    }

    public String getAutograph()
    {
        return autograph;
    }

    @Override
    public String toString()
    {
        return this.publication.toString()+" "+getAutograph()+" |";
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