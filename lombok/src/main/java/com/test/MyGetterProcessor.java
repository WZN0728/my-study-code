package com.test;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

/**
 * @author wuting
 * @date 2020/06/05
 * com.test
 * -- MyGetter.java1
 * -- MyGetterProcessor.java2
 * -- TestAno.java3
 * -- GeneratedClass
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.test.MyGetter")
public class MyGetterProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        StringBuilder builder = new StringBuilder()
                .append("package com.test;\n\n")
                .append("public class GeneratedClass {\n\n")
                .append("\tpublic String getMessage() {\n")
                .append("\t\treturn \"");
        for (Element element : roundEnv.getElementsAnnotatedWith(MyGetter.class)) {
            String objectType = element.getSimpleName().toString();
            builder.append(objectType).append(" says hello!");
        }
        builder.append("\";\n")
                .append("\t}\n")
                .append("}\n");
        try {
            JavaFileObject source = processingEnv.getFiler().createSourceFile("com.test.GeneratedClass");
            Writer writer = source.openWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {

        }
        return true;
    }

}
