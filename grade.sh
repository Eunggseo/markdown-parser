
git clone $1
cp GradingTests.java markdown-parser/
cd markdown-parser

if [ -f "MarkdownParse.java" ]; then
    echo "MarkdownParse.java exists."
else
    echo "MarkdownParse.java does not exist."
fi

javac -cp lib/*:. GradingTests.java MarkdownParse.java
java -cp lib/*:. org.junit.runner.JUnitCore GradingTests
