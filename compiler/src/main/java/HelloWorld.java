import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class HelloWorld {


    public static void main(String[] args) {
        String input = "public class Example {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        int x;\n" +
                "        int y;\n" +
                "        int z;\n" +
                "        x = 24245;\n" +
                "        y = 11111;\n" +
                "        x = 2;\n" +
                "        z = x - 8345*y;\n" +
                "    }\n" +
                "}";
        final CodePointCharStream codePointCharStream = CharStreams.fromString(input);
        final Java8Lexer java8Lexer = new Java8Lexer(codePointCharStream);
        final CommonTokenStream commonTokenStream = new CommonTokenStream(java8Lexer);
        final Java8Parser java8Parser = new Java8Parser(commonTokenStream);
        final Java8BaseVisitor<Void> voidJava8BaseVisitor = new Java8BaseVisitor<Void>();
        voidJava8BaseVisitor.visit(java8Parser.compilationUnit());
    }
}
