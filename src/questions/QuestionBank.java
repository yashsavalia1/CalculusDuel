package questions;

import java.util.*;

import game.Game;
import game.Utility;

public class QuestionBank {

    public static List<Question> tempEulerQuestions = new ArrayList<Question>();
    public static final List<Question> eulerQuestions = new ArrayList<Question>();
    public static List<Question> tempRiemannQuestions = new ArrayList<Question>();
    public static final List<Question> riemannQuestions = new ArrayList<Question>();
    public static List<Question> tempGaussQuestions = new ArrayList<Question>();
    public static final List<Question> gaussQuestions = new ArrayList<Question>();
    public static List<Question> tempTaylorQuestions = new ArrayList<Question>();
    public static final List<Question> taylorQuestions = new ArrayList<Question>();
    public static List<Question> tempRivalQuestions = new ArrayList<Question>();
    public static final List<Question> rivalQuestions = new ArrayList<Question>();

    public static void setQuestions() {
        //TODO add questions
        {
            eulerQuestions.add(new Question(Utility.getImage("questions/euler1.png"), "e^3-1"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler2.png"), "8e"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler3.png"), "0"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler4.png"), "e^x"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler5.png"), "e"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler6.png"), "13/6"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler7.png"), "1/5"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler8.png"), "x+2"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler9.png"), "x+2"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler10.png"), "2e-2"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler11.png"), "e^x"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler12.png"), "4e^x"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler13.png"), "2e^2x"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler14.png"), "e^x-1"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler15.png"), "-1/e"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler16.png"), "e^2x/2"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler17.png"), "ln5/2"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler18.png"), "1/2"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler19.png"), "1"));
            eulerQuestions.add(new Question(Utility.getImage("questions/euler20.png"), "e^x"));
            tempEulerQuestions = new ArrayList<Question>(eulerQuestions);
        }
        {
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann1.png"), "5"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann2.png"), "over"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann3.png"), "36"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann4.png"), "π√2/8"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann5.png"), "π√2/8"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann6.png"), "under"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann7.png"), "under"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann8.png"), "1"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann9.png"), "5/8"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann10.png"), "17"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann11.png"), "over"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann12.png"), "20"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann13.png"), "20"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann14.png"), "6"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann15.png"), "8/3"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann16.png"), "40/9"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann17.png"), "2"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann18.png"), "72"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann19.png"), "35/2"));
            riemannQuestions.add(new Question(Utility.getImage("questions/riemann20.png"), "192"));
            tempRiemannQuestions = new ArrayList<Question>(riemannQuestions);
        }
        {
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss1.png"), "5/9"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss2.png"), "1/3"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss3.png"), "20"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss4.png"), "2π"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss5.png"), "18-4√6"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss6.png"), "243π/5"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss7.png"), "625π"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss8.png"), "32π"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss9.png"), "1/3"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss10.png"), "16/15"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss11.png"), "32π"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss12.png"), "9"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss13.png"), "64/5"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss14.png"), "4/3"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss15.png"), "8/3"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss16.png"), "42π/3"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss17.png"), "16π"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss18.png"), "4"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss19.png"), "8"));
            gaussQuestions.add(new Question(Utility.getImage("questions/gauss20.png"), "ln4"));
            tempGaussQuestions = new ArrayList<Question>(gaussQuestions);
        }
        {
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor1.png"), "0"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor2.png"), "1/2"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor3.png"), "∞"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor4.png"), "∞"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor5.png"), "d"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor6.png"), "c"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor7.png"), "c"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor8.png"), "4/3"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor9.png"), "sinx"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor10.png"), "cosx"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor11.png"), "lnx"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor12.png"), "6"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor13.png"), "96"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor14.png"), "1/2"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor15.png"), "c"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor16.png"), "d"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor17.png"), "d"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor18.png"), "10"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor19.png"), "1"));
            taylorQuestions.add(new Question(Utility.getImage("questions/taylor20.png"), "x^2/2"));
            tempTaylorQuestions = new ArrayList<>(taylorQuestions);

        }
        {
            rivalQuestions.add(new Question(Utility.getImage("questions/rival1.png"), "5x^2"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival2.png"), "3x^2-6x"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival3.png"), "-7/121"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival4.png"), "-1"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival5.png"), "92"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival6.png"), "48x^2+18x-9"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival7.png"), "24x^3+4x-6"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival8.png"), "-15"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival9.png"), "-2,2"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival10.png"), "4"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival11.png"), "2,6"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival12.png"), "2"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival13.png"), "3"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival14.png"), "2x^3+2x^2-6x+c"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival15.png"), "c"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival16.png"), "x^4+x^2+195x+c"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival17.png"), "9"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival18.png"), "x^5-x^3+x^2+c"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival19.png"), "2x^4+x^2-6x+c"));
            rivalQuestions.add(new Question(Utility.getImage("questions/rival20.png"), "-100"));

        }


    }

    public static void resetQuestions() {
        tempEulerQuestions = new ArrayList<Question>(eulerQuestions);
        tempTaylorQuestions = new ArrayList<Question>(taylorQuestions);
        tempGaussQuestions = new ArrayList<Question>(gaussQuestions);
        tempRivalQuestions = new ArrayList<Question>(rivalQuestions);
        tempRiemannQuestions = new ArrayList<Question>(riemannQuestions);
    }

    public static Question nextQuestion(Game.Character character) {
        if (character == Game.Character.EULER) {
            if (tempEulerQuestions.size() == 0) resetQuestions();
            Question q = tempEulerQuestions.get((int) (Math.random() * (tempEulerQuestions.size())));
            tempEulerQuestions.remove(q);
            return q;
        }

        if (character == Game.Character.RIEMANN) {
            if (tempRiemannQuestions.size() == 0) resetQuestions();
            Question q = tempRiemannQuestions.get((int) (Math.random() * (tempRiemannQuestions.size())));
            tempRiemannQuestions.remove(q);
            return q;
        }

        if (character == Game.Character.GAUSS) {
            if (tempGaussQuestions.size() == 0) resetQuestions();
            Question q = tempGaussQuestions.get((int) (Math.random() * (tempGaussQuestions.size())));
            tempGaussQuestions.remove(q);
            return q;
        }
        if (character == Game.Character.TAYLOR) {
            if (tempTaylorQuestions.size() == 0) resetQuestions();
            Question q = tempTaylorQuestions.get((int) (Math.random() * (tempTaylorQuestions.size())));
            tempTaylorQuestions.remove(q);
            return q;
        }
        if (character == Game.Character.NEWTON || character == Game.Character.LEIBNIZ) {
            if (tempRivalQuestions.size() == 0) resetQuestions();
            Question q = tempRivalQuestions.get((int) (Math.random() * (tempRivalQuestions.size())));
            tempRivalQuestions.remove(q);
            return q;
        }
        return null;
    }

}
