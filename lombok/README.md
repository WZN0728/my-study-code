运行：我们在demo汇总编译期就能生成文件了，在编译时生成文件，此时不要着急直接进行javac编译，MyGetter类是注解类没错，而MyGetterProcessor是注解类的处理器，那么我们在编译TestAnoJava文件的时候就会触发处理器。因此这两个类是无法一起编译的。
javac com/test/MyGetter*
javac -processor com.test.MyGetterProcessor com/test/TestAnno.java


lombok原理
 1.注解处理工具apt
  注解处理工具apt(Annotation Processing Tool)，这是Sun为了帮助注解的处理过程而提供的工具，apt被设计为操作Java源文件，而不是编译后的类。
 2.正常情况下使用APT工具只是能够生成一些文件(不仅仅是我们想象的class文件，还包括xml文件等等之类的)，并不能修改原有的文件信息
 3.其实Lombok是修改了Java中的**抽象语法树AST**才做到了修改其原有类的信息
 编译时解析有两种机制，分别简单描述下：
   1）Annotation Processing Tool
   apt自JDK5产生，JDK7已标记为过期，不推荐使用，JDK8中已彻底删除，自JDK6开始，可以使用Pluggable Annotation Processing API来替换它，apt被替换主要有2点原因：
   api都在com.sun.mirror非标准包下
   没有集成到javac中，需要额外运行
   2）Pluggable Annotation Processing API
   JSR 269自JDK6加入，作为apt的替代方案，它解决了apt的两个问题，javac在执行的时候会调用实现了该API的程序，这样我们就可以对编译器做一些增强
   对于这个 Java 编译器的工作流程，这里就直接引用官网的总结：
     Parse and Enter：所有在命令行中指定的源文件都被读取，解析成语法树，然后所有外部可见的定义都被输入到编译器的符号表中。
     Annotation Processing：调用所有适当的注释处理器。如果任何注释处理程序生成任何新的源文件或类文件，则重新开始编译，直到没有创建任何新文件为止。
     Analyse and Generate：最后，解析器创建的语法树将被分析并转换为类文件。在分析过程中，可能会发现对其他类的引用。编译器将检查这些类的源和类路径，如      果在源路径上找到它们，也会编译这些文件，尽管它们不需要进行注释处理。
