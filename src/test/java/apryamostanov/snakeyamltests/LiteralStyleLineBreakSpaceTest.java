package apryamostanov.snakeyamltests;

import org.junit.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class LiteralStyleLineBreakSpaceTest {

    @Test
    public void test() {
        DumperOptions options = new DumperOptions();
        options.setDefaultScalarStyle(DumperOptions.ScalarStyle.LITERAL);
        Yaml yaml = new Yaml(options);
        String correct = "this is some text with \"quotes\" and\nline breaks";
        String correctYaml = yaml.dump(correct);
        System.out.println(correctYaml);
        assert correctYaml.contains("|");
        String inCorrect = "this is some text with \"quotes\" and \n line breaks";
        String inCorrectYaml = yaml.dump(inCorrect);
        System.out.println(inCorrectYaml);
        assert inCorrectYaml.contains("|");
    }

}
