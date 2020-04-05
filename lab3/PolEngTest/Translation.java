import java.security.PublicKey;

public class Translation{
    private String original;
    private String[] answer;

    public Translation(String q, String[] a){
        this.original = q;
        this.answer = a;
    }

    public String getOriginal(){
        return original;
    }

    public String[] getAnswer(){
        return answer;
    }

    public static double compareAnswers(String user_answer, String[] answer){
        double flag = 0;
        user_answer = user_answer.toLowerCase();
        for(String string : answer){
            if(Levenshtein.LevenshteinCount(user_answer, string) == 0){
                flag = 1;
            }
            else if(Levenshtein.LevenshteinCount(user_answer, string) == 1){
                flag = 0.5;
            }
        }
        return flag;
    }
}
