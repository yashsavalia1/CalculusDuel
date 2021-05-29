package latex;

import java.io.IOException;

public class Latex {

    public static String br = "\\\\ \\; \\\\ \\; \\\\ \\Huge ";

    public static void main(String[] args) {
        String[] eulerQuestions;
        {
            eulerQuestions =
                    new String[]{"\\text{Find the area enclosed between } \\\\ \\; \\\\ \\; \\\\" + spaces(9) +
                            "\\Huge y=e^x," +
                            "\\; x = 0, \\text{ and } x = 3",
                            "\\text{Find } \\frac{dy}{dx}|_{x=\\frac{1}{8}} \\text{ for }" + br + spaces(2) +
                                    " y=(e^{2x})^{4} - 6",
                            " \\text{If } y=" + integral("0", "t", "e^{2x} + e^x") +
                                    "\\text{ what is } y \\text{ when t=0?}",
                            " \\text{The function represented by this Taylor Series: } \\\\ \\; \\\\ \\; \\\\ " +
                                    spaces(40) + "\\Huge1 + x + \\frac{x^2}{2} + \\frac{x^3}{3} +\\frac{x^4}{4}…",
                            "\\text{Find the slope of the tangent }" + br + "\\text{of the graph } y=e^{e^x} \\text{ " +
                                    "at } x=0",
                            "\\text{If } y=" + integral("1", "t", "\\frac{13}{6x}") + "\\text{ what is } y \\text{ " +
                                    "when } t=e \\text{?}",
                            "\\text{Find the slope of the tangent of the graph }" + br + spaces(15) +
                                    "\\Huge y=\\ln{x} + 3 \\text{ at } x = 5",
                            "\\text{Find the equation of the tangent of the graph: }" + br + spaces(6) +
                                    " y=e^x + 1 \\text{ at } x=0 " +
                                    "\\text{ in y-intercept form} ",
                            "\\text{Find the equation of the tangent of the graph: }" + br + spaces(3) + "y" +
                                    "=\\ln(x)+3 \\text{ at } x=1 \\text{ in y-intercept form} ",
                            "\\text{Find the area under the curve: } " + br + spaces(1) + "y=e^{x/2} " +
                                    "\\text{ from } x=0 \\text{ to } x=2",
                            "\\text{      Solve for } y: \\frac{dy}{dx}=y " + br + "\\text{ given that when } x=0,y=1",
                            " \\text{Differentiate: } 2(e^x + e^x) ",
                            "\\text{Differentiate: } e^x \\cdot e^x",
                            " \\text{Find the antiderivative of: } e^x" + br + spaces(1) + "\\text{such that when } " +
                                    "y=0, x=0",
                            " \\text{Find the slope of the tangent of: } \\frac{1}{e^x} \\text{ at } x=1 ",
                            " \\text{Find the antiderivative of: } (e^x)^2 " + br + spaces(2) + "\\text{such that " +
                                    "when } x=0, y=\\frac{1}{2}",
                            " \\text{Find the area under the curve: } y=\\frac{1}{2x} \\text{ from } [1,5] ",
                            " \\text{Find the area under the curve: } y=e^{2x} \\text{ from } [-\\infty,0] ",
                            " \\text{Find the slope of the tangent of: } " + br + spaces(9) + "y=\\ln(5x) \\text{ at " +
                                    "} x=1 ",
                            " \\text{Differentiate: } e^x ",
                    };
        }

        String[] riemannQuestions;
        {
            riemannQuestions = new String[]{
                    " \\text{Use RRAM to estimate the area under}" + br + "\\text{the curve of } y=x^2 \\text{ from }" +
                            " [0,2] \\text{ with} " + br + " \\text{2 subintervals} ",

                    " \\text{Will the RRAM of the graph } y=2^x" + br + " \\text{be an overestimate or underestimate " +
                            "}" + br + "\\text{of the true area? (over / under)}",


                    " \\text{Use RRAM to estimate the area under}" + br + "\\text{the curve of } y=x^3 \\text{ from }" +
                            " [0,3] \\text{ with} " + br + "\\text{3 subintervals}",


                    " \\text{Use RRAM to estimate the area under}" + br + "\\text{the curve of } y=cos(x) \\text{ " +
                            "from } [0," +
                            "\\frac{\\pi}{2}] \\text{ with }" + br + "\\text{2 subintervals}",


                    " \\text{Use LRAM to estimate the area under}" + br + "\\text{the curve of } y=sin(x) \\text{ " +
                            "from } [0," +
                            "\\frac{\\pi}{2}] \\text{ with }" + br + "\\text{2 subintervals}",


                    " \\text{Will the LRAM of the graph } y=2^x" + br + " \\text{be an overestimate or underestimate " +
                            "}" + br + "\\text{of the true area? (over / under)}",


                    " \\text{Will the LRAM of the graph } y=-2^x" + br + " \\text{be an overestimate or underestimate" +
                            " }" + br + "\\text{of the true area? (over / under)}",


                    " \\text{Use LRAM to estimate the area under}" + br + "\\text{the curve of } y=x^2 \\text{ from }" +
                            " [0,2] \\text{ with} " + br + "\\text{2 subintervals}",


                    " \\text{Use RRAM to estimate the area under}" + br + "\\text{the curve of } y=\\frac{1}{x^2} " +
                            "\\text{ from } [0,4]" +
                            " \\text{ with }" + br + "\\text{2 subintervals}",


                    " \\text{Use RRAM to estimate the area under}" + br + "\\text{the curve of } y=x^4 \\text{ from }" +
                            " [0,2] \\text{ with} " + br + "\\text{2 subintervals}",


                    " \\text{Will the RRAM of the graph } y=6x^2-3x" + br + " \\text{be an overestimate or " +
                            "underestimate }" + br + "\\text{of the true area? (over / under)}",


                    " \\text{Use MRAM to estimate the area under}" + br + "\\text{the curve of } y=x^2 \\text{ from }" +
                            " [0,4] \\text{ with} " + br + "\\text{2 subintervals}",


                    " \\text{Use MRAM to estimate the area under}" + br + "\\text{the curve of } y=2^x \\text{ from }" +
                            " [0,4] \\text{ with} " + br + "\\text{2 subintervals}",


                    " \\text{Use MRAM to estimate the area under}" + br + "\\text{the curve of } y=4x^2-2 \\text{ " +
                            "from } [0,2] \\text{ with} " + br + " \\text{2 subintervals}",


                    " \\text{Use MRAM to estimate the area under}" + br + "\\text{the curve of } y=\\frac{1}{x} " +
                            "\\text{ from } [0,1] " +
                            "\\text{ with }" + br + "\\text{2 subintervals}",


                    " \\text{Use MRAM to estimate the area under}" + br + "\\text{the curve of } y=\\frac{1}{x^2} " +
                            "\\text{ from } [0,2]" +
                            " \\text{ with }" + br + "\\text{2 subintervals}",


                    " \\text{Use LRAM to estimate the area under}" + br + "\\text{the curve of } y=6x^2-4x-2 \\text{ " +
                            "from } [0,2] " +
                            "\\text{ with }" + br + "\\text{2 subintervals}",


                    " \\text{Use TRAM to estimate the area under}" + br + "\\text{the curve of } y=3x^2 \\text{ from " +
                            "} [0,4] \\text{ with} " + br + "\\text{2 subintervals}",


                    " \\text{Use TRAM to estimate the area under}" + br + "\\text{the curve of } y=9-x^2 \\text{ from" +
                            " } [0,3] \\text{ with} " + br + "\\text{3 subintervals}",


                    " \\text{Use TRAM to estimate the area under}" + br + "\\text{the curve of } y=x^2 \\text{ from }" +
                            " [0,8] \\text{ with} " + br + "\\text{2 subintervals}",


            };

        }

        String[] gaussQuestions;

        {
            gaussQuestions = new String[]{
                    " \\text{Find the area enclosed between: }" + br + " y=\\sqrt{x}, \\text{and } y=x^8",

                    " \\text{Find the area enclosed between: }" + br + " y=\\sqrt{x} \\text{, and } y=x^2",

                    " \\text{Find the area enclosed between: }" + br + " y=5x^4-6x^2+2, \\; x=0 \\text{, and } x=2",

                    " \\text{Find the area enclosed between: }" + br + " y=cos(x)+1, \\; x=2\\pi \\text{, and } x= 0",


                    " \\text{Find the area enclosed between: }" + br + " x=y^2,\\; x=-y+6 \\text{ and the $x$-axis}",

                    " \\text{Find the volume of the region bounded by }" + br + "y=\\sqrt{x} \\text{ and } " +
                            "y=3 \\text{ rotated about the $y$-axis}",

                    " \\text{Find the volume of the region bounded by } " + br + " y=x^2 \\text{ and } x=5 \\text{ " +
                            "rotated about the $x$-axis}",

                    " \\text{Find the volume of the region bounded by } " + br + "y=4, \\: y=2 \\text{, and } x=4 " +
                            "\\text{ rotated about the $y$-axis}",


                    "\\text{Find the area enclosed between: }" + br + " y=x^2, \\text{ and } x=y^2",


                    "\\text{Find the area enclosed between: }" + br + " y=x^4-2x^2+1  \\text{ aka } (x^2-1)^2 \\text{" +
                            " and the x-axis}",

                    " \\text{Find the volume of the region bounded by } " + br + "y=4, \\: y=3, \\: x=6 \\text{ and " +
                            "the $y$-axis} \\text{ rotated about the x-axis}",


                    " \\text{Find the volume of a shape with a base}" + br + "\\text{of the region enclosed by } " + br +
                            "y=x, \\: x=3, \\text{ and the $y$-axis}" + br + "\\text{with a cross sectional area of a" +
                            " square}",

                    " \\text{Find the volume of a shape with a base}" + br + "\\text{of the region enclosed by } " + br +
                            "y=x^2, \\: x=-2, \\text{ and } x=2" + br + "\\text{with a cross sectional area of a" +
                            " square}",


                    " \\text{Find the volume of a shape with a base}" + br + " \\text{of the region enclosed by } " +
                            "y=x, \\: x=2," + br + "\\text{and the $x$-axis with a cross sectional area}" + br +
                            "\\text{of an isosceles triangle}",


                    " \\text{Find the volume of a shape with a base}" + br + " \\text{of the region enclosed by } " +
                            "y=2x, \\: x=2, " + br + "\\text{and the $x$-axis with a cross sectional area }" + br +
                            "\\text{of an isosceles triangle}",


                    " \\text{Find the volume of the region bounded by } " + br + " y=\\frac{x}{2}, \\: x=2, \\text{ " +
                            "and the x-axis} " + br + "\\text{rotated about the x-axis}",


                    " \\text{Find the volume of the region bounded by } " + br + " y=4, \\: x=-2,  \\text{ and } x=2 " +
                            br + "\\text{rotated about the x-axis}",

                    "\\text{Find the area enclosed by }" + br + "\\sin{x},\\; x = 0, \\text{ and } x = 2\\pi",


                    " \\text{Find the volume of a shape with a base}" + br + "\\text{of the region enclosed by } " +
                            "\\sqrt{x}, \\text{ and } x=4 " + br + " \\text{with a cross sectional area of a square}",


                    " \\text{Find the area enclosed by }" + br + " y=\\frac{1}{x}, \\: x=1, \\text{ and } x=4",};
        }

        String[] taylorQuestions;

        {
            taylorQuestions = new String[]{
                    " \\text{Taylor polynomial of degree zero}" + br + " \\text{generated by } y=\\ln x \\text{ at } " +
                            "x = 1 \\text{ is:}",


                    " \\text{Maclaurin series of degree zero for } y=\\frac{1}{x+2}",


                    " \\text{Perform the ratio test on } \\sum_{n=0}^{\\infty} \\frac{n!}{5^n}" + br +
                            "\\text{(If infinity use ``inf\")}",


                    " \\text{Perform the ratio test on } \\sum_{n=0}^{\\infty} \\frac{(2n)!}{2n+1} " + br +
                            "\\text{(If infinity use ``inf\")}",


                    " \\text{Perform a test on } \\sum_{n=0}^{\\infty} \\frac{n^3}{n^4+4} " + br +
                            "\\text{and determine if it converges(c)}" + br + "\\text{or diverges(d) } ",


                    " \\text{Perform a test on } \\sum_{n=0}^{\\infty} \\frac{2}{n^2+2} " + br + "\\text{and " +
                            "determine if it converges (c)}" +
                            br + "\\text{or diverges(d)} ",


                    " \\text{Determine whether } \\sum_{n=0}^{\\infty} \\frac{3^n}{(5^n+1)} " + br +
                            "\\text{converges (c) or diverges(d) } ",


                    " \\text{Determine what } \\sum_{n=0}^{\\infty} \\biggl(\\frac{1}{4}\\biggr)^n " +
                            "\\text{ converges to } ",


                    " \\text{What is the function represented}" + br + "\\text{by this Taylor series: } " + br +
                            " x-\\frac{x^3}{3!}+\\frac{x^5}{5!}-\\frac{x^7}{7}...",


                    " \\text{What is the function represented}" + br + "\\text{by this Taylor series: }" + br +
                            "\\sum_{n=0}^{\\infty} \\frac{(-1)^n (x^{2n})}{(2n)!}  ",

                    " \\text{The function represented by this Taylor series: }" + br +
                            "(x-1)-\\frac{(x-1)^2}{2}+\\frac{(x-1)" +
                            "^3}{3}-\\frac{(x-1)^4}{4} ... \\text{ is} ",


                    " \\text{What is the second derivative of the function}" + br + "\\text{with a series of  } " +
                            "2- 2x + 3x^2 - \\frac{5x^3}{2}... ",


                    " \\text{What is the third derivative of the function}" + br + "\\text{with a series of } " +
                            "15+2x-5x^2+4x^4...",


                    " \\text{What is the first derivative of the function}" + br +
                            "\\text{with a series generated by } 2 + \\frac{x}{2} + 3x^2 + 4x^2...",


                    " \\text{Determine whether } \\sum_{n=0}^{\\infty} \\frac{1}{n^8} " + br +
                            "\\text{ converges (c) or diverges(d) } ",


                    " \\text{Determine whether } \\sum_{n=0}^{\\infty} \\frac{1}{n^{\\frac{1}{2}}}" + br +
                            "\\text{converges(c) or diverges(d)} ",


                    " \\text{Determine whether } \\sum_{n=0}^{\\infty} \\frac{6^n}{3^n+16} " + br +
                            "\\text{converges (c) or diverges(d)}",


                    " \\text{Determine what } \\sum_{n=0}^{\\infty} 5 \\biggl(\\frac{1}{2}\\biggr)^n \\text{ " +
                            "converges to } ",


                    " \\text{What is the coefficient of the 4th term of }" + br +
                            " x+x^2+x^3+x^4 \\text{ centered at } x = 1",


                    " \\text{What is the third term of } e^x " + br + "\\text{centered at } x = 0?",
            };
        }

        String[] rivalQuestions;

        {
            rivalQuestions = new String[]{
                    " \\text{Differentiate } \\frac{5x^3}{3} ",
                    " \\text{Differentiate } x(x^2 - 3x) ",
                    " \\text{Find the slope of the tangent of } " + br + "\\frac{1}{x+6x+4} \\text{ at } x = 1",
                    "\\text{Find the slope of the tangent of } " + br + "\\frac{x}{7x^2-7x} \\text{ at } x = 0",
                    " \\text{Find the slope of the tangent of }" + br + " 5x^3+8x^2+4 \\text{ at } x = 2",
                    " \\text{Differentiate } y=16x^3+9x^2-9x+15 ",
                    " \\text{Differentiate } y=6x^4+2x^2-6x ",
                    " \\text{Find the slope of the tangent of } " + br + "y=16x^2 - 15x + 4 \\text{ at } x = 0",
                    " \\text{Find inflection points: } y=\\frac{x^4}{12} - 2x^2 ",
                    " \\text{Find inflection points: } y=\\frac{x^3}{3} - 4x^2 ",
                    " \\text{Where must a continuous function on [2,6]} " + br + "\\text{have relative extrema?} ",
                    " \\text{Find the slope of the tangent of } " + br + " sqrt(x^2 - 3) at x = 2",
                    " \\text{Find the average value of } y=2x \\text{ from } [1,2] ",
                    " \\text{Find the antiderivative of } 6x^2+4x-6 ",
                    " \\text{Find the antiderivative of } 0",
                    " \\text{Find the antiderivative of } 4x^3 + 2x + 195 ",
                    " \\text{Find the average value of }" + br + " y=9 \\text{ from } [5, 10]",
                    " \\text{Find the antiderivative of } 5x^4-3x^2+2x ",
                    " \\text{Find the antiderivative of } 8x^3+2x-6 ",
                    " \\text{Integrate } 6x^2-7 \\text{ from } [0, -4] ",
            };

        }


//        {
//            String[] integrationQuestions = {"\\text{Average value of } y = 2x \\text{ from } [1, 2]"};
//            String y = "\\large" + frac("-1", "2" + sqrt("x^2-4")) +
//                    "or \\; ${-2(x^2 - 4)}^{-\\frac{1}{2}}$\\\\" + spaces(15) + "\\biggl(\\frac{121}{12}-1\\biggr)" +
//                    "^{\\!2}";
//            String x = "\\biggl(\\frac{121}{12}-1\\biggr)^{\\!2}";
//            String z = "\\Huge\\ln e^x = x";
//            String a = "\\Huge" + integral("x^2", "x^3", frac("1+x", "2-4"));
//
//
//            String latex = "\\begin{array}{lr}\\mbox{\\textcolor{Blue}{Russian}}&\\mbox{\\textcolor{Melon}{Greek
//            }}\\\\";
//            {
//                latex += "\\mbox{" + "привет мир".toUpperCase() + "}&\\mbox{" + "γειά κόσμο".toUpperCase() + "}\\\\";
//                latex += "\\mbox{привет мир}&\\mbox{γειά κόσμο}\\\\";
//                latex += "\\mathbf{\\mbox{привет мир}}&\\mathbf{\\mbox{γειά κόσμο}}\\\\";
//                latex += "\\mathit{\\mbox{привет мир}}&\\mathit{\\mbox{γειά κόσμο}}\\\\";
//                latex += "\\mathsf{\\mbox{привет мир}}&\\mathsf{\\mbox{γειά κόσμο}}\\\\";
//                latex += "\\mathtt{\\mbox{привет мир}}&\\mathtt{\\mbox{γειά κόσμο}}\\\\";
//                latex += "\\mathbf{\\mathit{\\mbox{привет мир}}}&\\mathbf{\\mathit{\\mbox{γειά κόσμο}}}\\\\";
//                latex += "\\mathbf{\\mathsf{\\mbox{привет мир}}}&\\mathbf{\\mathsf{\\mbox{γειά κόσμο}}}\\\\";
//                latex += "\\mathsf{\\mathit{\\mbox{привет мир}}}&\\mathsf{\\mathit{\\mbox{γειά κόσμο}}}\\\\";
//                latex += "&\\\\";
//                latex += "\\mbox{\\textcolor{Salmon}{Bulgarian}}&\\mbox{\\textcolor{Tan}{Serbian}}\\\\";
//                latex += "\\mbox{здравей свят}&\\mbox{Хелло уорлд}\\\\";
//                latex += "&\\\\";
//                latex += "\\mbox{\\textcolor{Turquoise}{Bielorussian}}&\\mbox{\\textcolor{LimeGreen}{Ukrainian}}\\\\";
//                latex += "\\mbox{прывітаньне Свет}&\\mbox{привіт світ}\\\\";
//                latex += "\\end{array}";
//            }
//        }

        try {
            for (int i = 0; i < gaussQuestions.length; i++)
                Convert.toSVG("\\Huge" + gaussQuestions[i], "gauss" + (i + 1) + ".svg", true);

            for (int i = 0; i < eulerQuestions.length; i++)
                Convert.toSVG("\\Huge" + eulerQuestions[i], "euler" + (i + 1) + ".svg", true);

            for (int i = 0; i < riemannQuestions.length; i++)
                Convert.toSVG("\\Huge" + riemannQuestions[i], "riemann" + (i + 1) + ".svg", true);

            for (int i = 0; i < taylorQuestions.length; i++)
                Convert.toSVG("\\Huge" + taylorQuestions[i], "taylor" + (i + 1) + ".svg", true);

            for (int i = 0; i < rivalQuestions.length; i++)
                Convert.toSVG("\\Huge" + rivalQuestions[i], "rival" + (i + 1) + ".svg", true);


            //            Convert.toSVG(y, "Example2.svg", true);
//            Convert.toSVG(x, "Example3.svg", true);
//            Convert.toSVG(integrationQuestions[0], "Example4.svg", true);
        } catch (
                IOException ex) {
            throw new RuntimeException(ex);
        }


    }

    public static String spaces(int spaces) {
        String spaceStr = "";

        for (int i = 0; i < spaces; i++) {
            spaceStr += "\\;";
        }

        for (int i = 0; i > spaces; i--) {
            spaceStr += "\\!";
        }

        return spaceStr;
    }

    public static String integral(String bottomLimit, String topLimit, String integrand) {
        return "\\int_{" + bottomLimit + "}^{" + topLimit + "}" + integrand + spaces(1) + "dx";
    }

    public static String sqrt(String radicand) {
        return "\\sqrt{" + radicand + "}";
    }

    public static String frac(String num, String denom) {
        return "\\frac{" + num + "}{" + denom + "}";
    }
}