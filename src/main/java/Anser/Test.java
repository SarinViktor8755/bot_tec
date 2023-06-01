package Anser;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {

    ArrayList<modelQuestion> questions;
    ArrayList<modelQuestion> redsult;
    private boolean flagQ;
    private modelQuestion tempQuesr;
    private String urlFile;



    public Test(String url) throws IOException {
        questions = new ArrayList<modelQuestion>();
        readText(url);
        flagQ = false;
        tempQuesr = new modelQuestion();

    }

    public ArrayList<modelQuestion> getQuestions() {
        return questions;
    }

    public boolean restartFileReader(){
        this.getQuestions().clear();
        try {
            this.readText(this.urlFile);
        }catch (IOException e){
            return false;
        }
        return true;

    }

    private void readText(String url) throws IOException {
        this.urlFile = url;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(url), Charset.forName("UTF-8")));
        try {

            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
                if (line == null || line.indexOf("Билет №") > -1) continue;
                if (line.indexOf("Вопрос") > -1) {
                    line = br.readLine();
                    tempQuesr = new modelQuestion();
                    tempQuesr.setQuestion(line);
                }
                if (tempQuesr == null) continue;

                if (line.indexOf("Правильный ответ") > -1) tempQuesr.setAnswer(formatAnser(line));
                if (tempQuesr.getAnswer() != null && tempQuesr.getQuestion() != null) {
                    questionsAdd(tempQuesr);
                    tempQuesr = null;
                }
            }
            //  String everything = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }

        System.out.println(questions.size());

        //printQ();
        //fine("свар");

        //System.out.println(questions.size());

    }

    private String formatAnser(String text) {
        return text.substring(0, text.indexOf("Правильный ответ")).trim();
    }

    private void questionsAdd(modelQuestion q) {
        for (int i = 0; i < questions.size(); i++) {
            if (q.getQuestion().equals(questions.get(i).getQuestion())) return;
        }
        questions.add(q);
    }

    private void parsingLine(String line) {
        if (line.length() < 1) return;
        //if(line.)
        System.out.println(line.indexOf("Вопрос №") > -1);
        System.out.println(line.indexOf("Билет №") > -1);
        System.out.println(line);
        System.out.println();
    }

    private void printQ() {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i).getQuestion());
            System.out.println(questions.get(i).getAnswer());
            System.out.println("--------");
        }
    }

    public ArrayList<modelQuestion> fine(String t) {
        if (t.equals("")) return redsult;
        redsult = new ArrayList<>();
        redsult.clear();
        for (int i = 0; i < questions.size(); i++) {
            if (containsIgnoreCase(questions.get(i).getQuestion(), t)) {
                redsult.add(questions.get(i));
            }
        }
        return redsult;

//        System.out.println(questions.size());
    }

    public static boolean containsIgnoreCase(String src, String what) {
        final int length = what.length();
        if (length == 0)
            return true; // Empty string is contained

        final char firstLo = Character.toLowerCase(what.charAt(0));
        final char firstUp = Character.toUpperCase(what.charAt(0));

        for (int i = src.length() - length; i >= 0; i--) {
            // Quick check before calling the more expensive regionMatches() method:
            final char ch = src.charAt(i);
            if (ch != firstLo && ch != firstUp)
                continue;

            if (src.regionMatches(true, i, what, 0, length))
                return true;
        }

        return false;
    }
}
