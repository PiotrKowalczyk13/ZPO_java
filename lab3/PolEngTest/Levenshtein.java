public class Levenshtein {
    static double LevenshteinCount(String s1, String s2){
        int i, j, len1, len2;
        double cost=0;

        len1=s1.length();
        len2=s2.length();

        double array[][] = new double[len1+1][len2+1];

        for(i = 0; i <= len1; i++){
            array[i][0] = i;
        }
        for(j = 0; j <= len2; j++){
            array[0][j] = j;
        }

        for(i = 1; i < (len1 + 1); i++){
            for(j = 1; j < (len2 + 1); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    cost = 0;
                }
                else{
                    cost = 1;
                }
                array[i][j] = Math.min(Math.min(array[i-1][j]+1, array[i][j-1]+1), array[i-1][j-1]+cost);
            }
        }

        return array[i-1][j-1];
    }
}
