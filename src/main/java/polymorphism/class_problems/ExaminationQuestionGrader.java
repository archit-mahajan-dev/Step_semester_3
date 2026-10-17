import java.util.*;

public class ExaminationQuestionGrader {
    interface Question { double score(); String type(); }
    static class ObjectiveQuestion implements Question {
        String kind, correct, answer; double points;
        ObjectiveQuestion(String k,String c,String a,double p){kind=k;correct=c;answer=a;points=p;}
        public double score(){return correct.equals(answer)?points:0;}
        public String type(){return kind;}
    }
    static class EssayQuestion implements Question {
        String keywords, answer; double points;
        EssayQuestion(String k,String a,double p){keywords=k;answer=a;points=p;}
        public double score(){
            String lowerAnswer=answer.toLowerCase(Locale.ROOT); int found=0;
            for(String word:keywords.split(",")) if(lowerAnswer.contains(word.trim().toLowerCase(Locale.ROOT))) found++;
            if(found>=2)return points*0.75;
            if(found==1)return points*0.50;
            return 0;
        }
        public String type(){return "ESSAY";}
    }
    // Input format uses each record on one line with quoted text fields.
    static List<String> quotedFields(String line) {
        List<String> out=new ArrayList<>(); java.util.regex.Matcher m=java.util.regex.Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        while(m.find()) out.add(m.group(1)!=null?m.group(1):m.group(2));
        return out;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); int n=Integer.parseInt(sc.nextLine().trim()); double total=0;
        for(int i=0;i<n;i++){
            List<String> p=quotedFields(sc.nextLine().trim()); String type=p.get(0); Question q;
            if(type.equals("MCQ")||type.equals("TF")) q=new ObjectiveQuestion(type,p.get(2),p.get(3),Double.parseDouble(p.get(4)));
            else q=new EssayQuestion(p.get(2),p.get(3),Double.parseDouble(p.get(4)));
            double score=q.score(); System.out.printf(Locale.US,"%s: %.2f%n",q.type(),score); total+=score;
        }
        System.out.printf(Locale.US,"Total Score: %.2f%n",total);
    }
}
