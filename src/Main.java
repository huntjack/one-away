public class Main {
    public static void main(String[] args) {
        System.out.println(isOneAway("pale", "palea"));
    }
    public static boolean isOneAway(String base, String candidate) {
        if (candidate.length() > base.length() + 1 | candidate.length() < base.length() - 1) {
            return false;
        }
        boolean edited = false;
        boolean last = false;
        int candidateCharIndex = 0;
        int i;
        for (i = 0; i < base.length() && candidateCharIndex < candidate.length(); i++) {
            char baseCharacter = base.charAt(i);
            int tempCandidateCharIndex = candidateCharIndex;
            for(int j = candidateCharIndex; j <= tempCandidateCharIndex + 1 &&
            j < candidate.length(); j++) {
                if (baseCharacter == candidate.charAt(j)) {
                    if(j == 1 && baseCharacter == base.charAt(0)) {
                        edited = true;
                    } else if (j == tempCandidateCharIndex + 1 && last && !edited) {
                        edited = true;
                    } else if (j == tempCandidateCharIndex + 1 && last && edited){
                        return false;
                    }
                    last = true;
                    candidateCharIndex = j + 1;
                    break;
                }
            }
            if(candidateCharIndex == tempCandidateCharIndex && !edited) {
                last = false;
                edited = true;
            } else if (candidateCharIndex == tempCandidateCharIndex && edited){
                return false;
            }
        }
        if(last == false && i == base.length()) {
            candidateCharIndex++;
        }
        int candidateDifference = candidate.length() - candidateCharIndex;
        int baseDifference = base.length() - i;
        if(edited && candidateDifference > 0 | baseDifference > 0) {
                return false;
        }
        return true;
    }
}